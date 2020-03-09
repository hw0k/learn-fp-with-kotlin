fun main() {
  println(sqrtAndDivide(2.0))
  println(sqrtAndDivide(6.0))
}

fun sqrtAndDivide(n: Double): Double = sqrt(n)

fun sqrt(n: Double): Double = divide(Math.sqrt(n))

fun divide(n: Double): Double {
  val divided: Double = n / 2.0
  return when {
    divided < 1 -> divided
    else -> sqrt(divided)
  }
}
