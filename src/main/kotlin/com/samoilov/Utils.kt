package com.samoilov

import org.slf4j.LoggerFactory
import java.lang.Exception


object Utils {
  private val log = LoggerFactory.getLogger(this::class.java)
  fun getByteArraySize(): Int {
    var byteArraySize = 5000
    try {
      byteArraySize = System.getenv("BYTE_ARRAY_SIZE").toInt()
    } catch (ex: NullPointerException) {
      log.warn("Read env BYTE_ARRAY_SIZE error")
    }
    return byteArraySize
  }
}
