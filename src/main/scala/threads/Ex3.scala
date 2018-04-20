package threads

import java.util.concurrent.atomic.AtomicInteger

object Ex3 {
  def main(args: Array[String]): Unit = {
//    @volatile var count = 0
//    val job: Runnable = () => (0 to 10).foreach(_ => count += 1)

    val count = new AtomicInteger(0)
    val job: Runnable = () => (0 until 10).foreach(_ => count.incrementAndGet())

    val t1 = new Thread(job)
    val t2 = new Thread(job)

    t1.start()
    t2.start()

    t1.join()
    t2.join()
    println(s"count value is $count")
  }
}