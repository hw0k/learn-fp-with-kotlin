fun main() {
  val func = { a: String, b: String, c: String -> "$a $b $c" }

  val par = func.partial1("I", "love")
  println(par("you")) // expect: I love you

  val par2 = func.partial2("Happy")
  println(par2("new", "year")) // expect: Happy new year

  val par3 = func.partial3("Somebody")
  val par4 = par3("help")
  println(par4("me")) // expect: Somebody help me

  val par5 = func.partial1("She", "is")
  val par6 = func.partial2("She")
  val par7 = func.partial3("She")
  val par8 = par7("is")

  println(par5("beautiful") == par6("is", "beautiful")) // expect: true
  println(par6("is", "beautiful") == par8("beautiful")) // expect: true
  println(par5("beautiful") == par8("beautiful")) // expect: true
}

fun <P1, P2, P3, R> ((P1, P2, P3) -> R).partial1(p1: P1, p2: P2): (P3) -> R {
  return { p3 -> this(p1, p2, p3) }
}

fun <P1, P2, P3, R> ((P1, P2, P3) -> R).partial2(p1: P1): (P2, P3) -> R {
  return { p2, p3 -> this(p1, p2, p3) }
}

fun <P1, P2, P3, R> ((P1, P2, P3) -> R).partial3(p1: P1): (P2) -> (P3) -> R {
  return { p2 -> { p3 -> this(p1, p2, p3) } }
}
