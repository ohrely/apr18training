package wilde

import scala.io.Source

object Counter {
  def processText(): Seq[(String, Int)] = {
    val text: Iterator[String] = Source.fromFile("readinggaol.txt").getLines()
    val words: Iterator[String] = text.flatMap(_.split("\\W+"))

    words.toSeq.groupBy(_.toLowerCase).filterKeys(_.length > 0).mapValues(_.length).toSeq.sortWith(_._2 > _._2)
  }


  def main(args: Array[String]): Unit = {
    processText().toArray.foreach(println)
  }
}
