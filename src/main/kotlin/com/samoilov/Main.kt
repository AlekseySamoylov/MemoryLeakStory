package com.samoilov

fun main() {
  val daemonThread = LoopThread()
  daemonThread.isDaemon = true
  daemonThread.start()

  val rocksDbDaemonThread = RocksDbLoop()
  rocksDbDaemonThread.isDaemon = true
  rocksDbDaemonThread.start()
  SocketListener.waitSignal()
  daemonThread.stopLoop()
  rocksDbDaemonThread.stopLoop()
}

