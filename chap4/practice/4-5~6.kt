fun main() {
  val list = listOf(4, -5, 12, 7)

  val cmax = { l: List<Int> -> cmax(l, Int.MIN_VALUE) }
  val cpower = { n: Int -> n * n }

  val one = cpower(cmax(list))
  println(one) // expect: 144

  val composed = cpower compose cmax
  val two = composed(list)
  println(two) // expect: 144
}

tailrec fun cmax(list: List<Int>, acc: Int): Int = when {
  list.size <= 1 -> acc
  else -> {
    val f = list.first()
    val next = if (f > acc) f else acc
    cmax(list.drop(1), next)
  }
}

infix fun <F, G, R> ((F) -> R).compose(g: (G) -> F): (G) -> R {
  return {
    gInput: G -> this(g(gInput))
  }
}
