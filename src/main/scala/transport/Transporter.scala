package transport

trait Transporter {
  val payload: Int
}

sealed case class Truck(payload: Int) extends Transporter
sealed case class Car(passengerCap: Int) extends Transporter {
  val payload: Int = (passengerCap - 1) * 170
}

class Logistics {
  def allocateFreight(vehicle: Transporter,
                      weight: Int): Boolean = {
    vehicle.payload >= weight
  }

  def checkAndTell(vehicle: Transporter,
                   weight: Int): Unit = {
    
  }
}

class MakeItHappen {
  def main(args: Array[String]): Unit = {

  }
}




