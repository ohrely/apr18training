package threads

object Ex1 {
  def main(args: Array[String]): Unit = {
    val t = new Thread(() => {
      println(s"Thread started, name is ${Thread.currentThread().getName}")
      (0 to 10) foreach println
      println("Thread finished")
    })

    t.start()

    println(s"main thread, name is ${Thread.currentThread().getName}... main exiting")
  }


}
