package date

object MyDate {
  def apply(y: Int, m: Int, d: Int): MyDate = {
    if (isValidDate(y, m, d)) new MyDate(y, m, d)
    else throw new IllegalArgumentException("Time and tides wait for no date")
  }

  def isValidDate(y: Int, m: Int, d: Int): Boolean = {
    true
  }
}

class MyDate protected(y: Int, m: Int, d: Int) {
  val year = y
  val month = m
  val day = d

  override def toString: String = s"$y/$m/$d"

  def addDays(add: Int): MyDate = MyDate(y, m, d + add)
}
