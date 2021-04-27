package com.samoilov

import org.slf4j.LoggerFactory
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.ServerSocket


object SocketListener {
  private const val port = 8080
  private val log = LoggerFactory.getLogger(this::class.java)
  fun waitSignal() {
    ServerSocket(port).let { serverSocket ->
      serverSocket.accept().let { socket ->
        BufferedReader(InputStreamReader(socket.getInputStream())).let { bufferedReader ->
          val line = bufferedReader.readLine()
          log.debug("Exit signal $line")
        }
      }
    }
  }
}
