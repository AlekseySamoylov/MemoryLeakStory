package com.samoilov

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Exception
import java.net.ServerSocket
import java.util.concurrent.TimeUnit

class Main {
  val list = mutableListOf<ByteArray>()
}
const val port = 8080

fun main() {
  val main = Main()
  var byteArraySize = 5000
  try {
    byteArraySize = System.getenv("BYTE_ARRAY_SIZE").toInt()
  } catch (ex: Exception) {
    println("Read env BYTE_ARRAY_SIZE error ${ex.message}")
  }
  val daemonThread = Thread {
    while (true) {
      main.list.add(ByteArray(byteArraySize))
      println("Wait user signal to port $port to interrupt. list size= ${main.list.size}")
      TimeUnit.MICROSECONDS.sleep(300)
    }
  }
  daemonThread.isDaemon = true
  daemonThread.start()
  ServerSocket(port).let { serverSocket ->
    serverSocket.accept().let { socket ->
      BufferedReader(InputStreamReader(socket.getInputStream())).let { bufferedReader ->
        val line = bufferedReader.readLine()
        println("Exit signal $line")
      }
    }
  }
}

