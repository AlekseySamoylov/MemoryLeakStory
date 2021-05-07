package com.samoilov

import com.samoilov.Utils.getByteArraySize
import org.rocksdb.Options
import org.rocksdb.RocksDB
import org.slf4j.LoggerFactory
import java.util.*
import java.util.concurrent.ThreadLocalRandom


class RocksDbLoop: Thread() {
  private val log = LoggerFactory.getLogger(this::class.java)
  @Volatile private var run = true
  init {
    RocksDB.loadLibrary()
  }

  override fun run() {
    val byteArray = ByteArray(getByteArraySize())
    ThreadLocalRandom.current().nextBytes(byteArray)
    val options = Options()
    options.setWriteBufferSize(500)
    options.setMaxWriteBufferNumber(4)
    options.setCreateIfMissing(true)
    val rocksDb = RocksDB.open(options, "./out")
    try {
      while (run) {
        val id = UUID.randomUUID().toString()
        rocksDb.put(id.toByteArray(), byteArray)
      }
    } finally {
      log.info("Closing db")
      rocksDb.closeE()
    }
  }

  fun stopLoop() {
    log.info("Stopping db loop")
    run = false
  }
}
