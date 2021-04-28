package com.samoilov

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
      log.debug("Hotswap3")
    }
    log.info("Loop is stopped")
  }

  fun stopLoop() {
    log.info("Stopping loop")
    run = false
  }

  private fun getByteArraySize(): Int {
    var byteArraySize = 5000
    try {
      byteArraySize = System.getenv("BYTE_ARRAY_SIZE").toInt()
    } catch (ex: Exception) {
      log.warn("Read env BYTE_ARRAY_SIZE error", ex)
    }
    return byteArraySize
  }
}




