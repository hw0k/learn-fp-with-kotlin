fun main() {
  println(sqrtAndDivideWithBounce(2.0))
  println(sqrtAndDivideWithBounce(6.0))
}

fun sqrtAndDivideWithBounce(n: Double): Double = trampoline(sqrtWithBounce(n))

fun sqrtWithBounce(n: Double): Bounce<Double> = More { divideWithBounce(Math.sqrt(n)) }

fun divideWithBounce(n: Double): Bounce<Double> {
  val divided: Double = n / 2.0
  return when {
    divided < 1 -> Done(divided)
    else -> More { sqrtWithBounce(divided) }
  }
}
