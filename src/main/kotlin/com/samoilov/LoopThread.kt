package com.samoilov

import com.samoilov.Utils.getByteArraySize
import org.slf4j.LoggerFactory
import java.lang.Exception

class LoopThread : Thread() {
  @Volatile
  private var run = true
  private val list = mutableListOf<ByteArray>()
  private val log = LoggerFactory.getLogger(this::class.java)
  override fun run() {
    val byteArraySize = getByteArraySize()
    while (run) {
      list.add(ByteArray(byteArraySize))
      log.debug("Wait user signal to socket to interrupt. list size={}", list.size)
      sleep(1000)
    }
    log.info("Loop is stopped")
  }

  fun stopLoop() {
    log.info("Stopping loop")
    run = false
  }
}




