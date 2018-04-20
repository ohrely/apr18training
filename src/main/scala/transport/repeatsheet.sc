def repeat(n: Int = 6)(func: => Unit): Unit = {
  (1 to n).foreach(_ => func)
}

repeat(2){
  println("Ahaha")
  println("Ahahaha")
}

repeat(2)( println("Bahaha") )

repeat(){ println("Cahaha") }