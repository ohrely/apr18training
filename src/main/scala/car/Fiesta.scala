package car

object Fiesta {
  def makeOne(fuel: Int): Fiesta = {
    val rv = new Fiesta
    rv.fuelLevel = fuel
    rv
  }
}

class Fiesta {
  var fuelLevel: Int = _

}

object TryThis {
  def main(args: Array[String]): Unit = {
    val f1 = Fiesta.makeOne(333)
    println(s"Fuel in the tank is ${f1.fuelLevel}")
  }
}
