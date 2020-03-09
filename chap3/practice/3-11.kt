fun main() {
  println(getFactorialWithTailrec(0)) // expect: 1
  println(getFactorialWithTailrec(1)) // expect: 1
  println(getFactorialWithTailrec(2)) // expect: 2
  println(getFactorialWithTailrec(3)) // expect: 6
  println(getFactorialWithTailrec(4)) // expect: 24
  println(getFactorialWithTailrec(5)) // expect: 120
}

fun getFactorialWithTailrec(n: Int): Int = getFactorialWithTailrec(n, 1)

tailrec fun getFactorialWithTailrec(n: Int, left: Int): Int = when (n) {
  0 -> left
  else -> getFactorialWithTailrec(n - 1, n * left)
}
