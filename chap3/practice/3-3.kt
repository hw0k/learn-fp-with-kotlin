fun main() {
  println(getFactorial(0)) // expect: 1
  println(getFactorial(1)) // expect: 1
  println(getFactorial(2)) // expect: 2
  println(getFactorial(3)) // expect: 6
  println(getFactorial(4)) // expect: 24
  println(getFactorial(5)) // expect: 120
}

fun getFactorial(n: Int): Int = when (n) {
  0 -> 1
  else -> n * getFactorial(n - 1)
}
