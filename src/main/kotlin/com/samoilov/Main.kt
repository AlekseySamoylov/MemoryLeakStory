package com.samoilov

fun main() {
  val memoryLoopThread = LoopThread()
  memoryLoopThread.name = "MemoryLoopThread"
  memoryLoopThread.start()
  val rocksDbLoopThread = RocksDbLoop()
  rocksDbLoopThread.name = "RocksDbThread"
  rocksDbLoopThread.start()

  SocketListener.waitSignal()

  memoryLoopThread.stopLoop()
  rocksDbLoopThread.stopLoop()
}

