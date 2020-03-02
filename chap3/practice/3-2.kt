fun main() {
  println(power(3.0, 3)) // expect: 27.0
  println(power(4.0, 2)) // expect: 16.0
  
  println(power(2.0, 4) == power(2.0, 3) * 2.0) // expect: true
}

fun power(x: Double, n: Int): Double = when {
  n == 0 -> 1.0
  n == 1 -> x
  else -> x * power(x, n - 1)
}
