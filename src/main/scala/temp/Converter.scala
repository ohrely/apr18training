package temp

object Converter {
  def fToC(far: Float = 98.4f): Float = 5 * (far - 32) / 9

  def dateToDay(y: Int, m: Int, d: Int): Int = {
    val (zm, zy) = {
      if (m < 3) (12 + m, y - 1)
      else (m, y)
    }

    (d + 13*(zm+1)/5 + zy + zy/4 - zy/100 + zy/400) % 7
  }

  val days: Array[String] = Array("Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday")

  def dateToMsg(y: Int, m: Int, d: Int): String = {
    val day = days(dateToDay(y, m, d))

    s"$y/$m/$d was a $day"
  }
}

object Entry {

  def main(args: Array[String]): Unit = {

//    println("Enter a temperature in Faranheit to convert to Celcius:")
//    val far = scala.io.StdIn.readLine.toFloat
//    val cel = Converter.fToC(far)
//
//    println(f"$far degrees F is $cel degrees C")

    println("Dates as Days:")
    println(Converter.dateToMsg(2000, 1, 1))
    println(Converter.dateToMsg(2000, 2, 29))
    println(Converter.dateToMsg(2000, 3, 1))
  }
}


