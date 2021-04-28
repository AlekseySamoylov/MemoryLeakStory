package com.samoilov

import org.rocksdb.Options
import org.rocksdb.RocksDB
import org.slf4j.LoggerFactory
import java.util.*


class RocksDbLoop: Thread() {
  private val log = LoggerFactory.getLogger(this::class.java)
  @Volatile private var run = true
  init {
    RocksDB.loadLibrary()
  }

  override fun run() {
    val options = Options()
    options.setCreateIfMissing(true)
    val rocksDb = RocksDB.open(options, "./db")
    try {
      while (run) {
        val id = UUID.randomUUID().toString()
        rocksDb.put(id.toByteArray(), id.toByteArray())
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
