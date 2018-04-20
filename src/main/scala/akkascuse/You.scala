package akkascuse

import akka.actor.{Actor, ActorRef, ActorSystem, Props}

sealed case class Msg(s: String)

class PoliteActor(sidekick: ActorRef) extends Actor {
//  override def receive: PartialFunction[Any, Unit] = new PartialFunction[Any, Unit](){
//    override def isDefinedAt(x: Any): Boolean = x.isInstanceOf[Msg]
//
//    override def apply(v1: Any): Unit = v1 match {
//      case Msg("sneeze") => println("Bless you.")
//      case Msg("burp") => println("Excuse you.")
//      case Msg(x) => println(s"$x?  How rude.")
//    }
//  }
  override def receive: Receive = {
    case Msg("sneeze") =>
      println(s"You sneezed at poly. \n${self.toString()}: Bless you.")
    case Msg("burp") =>
      println(s"You burped at poly.  \n${self.toString()}: Excuse you.")
    case Msg("die") =>
      println(s"${self.toString()}: Fare thee well.\nYou killed poly.")
      context.system.stop(self)
    case x: Msg =>
      println(s"You said '${x.s}' at poly. \n${self.toString()}: I'm gonna let my sidekick take this one.")
      sidekick ! x
  }
}

class RudeActor extends Actor {
  override def receive: Receive = {
    case Msg("die") =>
      println(s"${self.toString()}: Later loser.\nYou killed rudy.")
      context.system.stop(self)
    case Msg(_) => println(s"${self.toString()}: Your face.")
  }
}

object You {
  def main(args: Array[String]): Unit = {
    val system = ActorSystem("system")
    val rude = system.actorOf(Props[RudeActor], "rudy")
    val polite: ActorRef = system.actorOf(Props(classOf[PoliteActor], rude), "poly")

    println("You sneeze at poly.")
    polite ! Msg("sneeze")

    println("You burp at poly.")
    polite ! Msg("burp")

    println("You burble at poly.")
    polite ! Msg("burble")

    println("You send poly an int.  (Nothing happens.)")
    polite ! 22 // should be a dead letter

    Thread.sleep(1000)

    println("You kill poly.")
    polite ! Msg("die")

    println("You kill rudy.")
    rude ! Msg("die")

    Thread.sleep(1000)

    system.terminate()
  }
}
