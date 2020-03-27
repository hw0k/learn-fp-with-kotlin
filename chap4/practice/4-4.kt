fun main() {
  val curried = min.curried()
  val one = curried(1)(2)

  val uncurried = curried.uncurried()
  val two = uncurried(1, 2)

  println(one == two) // expect: true
}

val min = {
  left: Int, right: Int -> when {
    left > right -> right
    else -> left
  }
}

fun <P1, P2, R> ((P1, P2) -> R).curried(): (P1) -> (P2) -> R = {
  p1: P1 -> {
    p2: P2 -> this(p1, p2)
  }
}

fun <P1, P2, R> ((P1) -> (P2) -> R).uncurried(): (P1, P2) -> R = {
  p1: P1, p2: P2 -> this(p1)(p2)
}
