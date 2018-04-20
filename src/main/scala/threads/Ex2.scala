package threads

object Ex2 {
  def main(args: Array[String]): Unit = {
    @volatile var stop = false
//    var stop = false
    val t = new Thread(() => {
      println(s"Thread started, name is ${Thread.currentThread().getName}")
      while(!stop) {
//        (0 to 10)
      }
      println("Thread finished")
    })

    t.start()
    Thread.sleep(1000)
    stop = true
    println(s"main thread, name is ${Thread.currentThread().getName}... main exiting")
  }
}
