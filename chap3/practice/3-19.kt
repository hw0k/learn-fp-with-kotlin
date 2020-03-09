fun main() {
  println(getFactorialWithMutual(0)) // expect: 1
  println(getFactorialWithMutual(1)) // expect: 1
  println(getFactorialWithMutual(2)) // expect: 2
  println(getFactorialWithMutual(3)) // expect: 6
  println(getFactorialWithMutual(4)) // expect: 24
  println(getFactorialWithMutual(5)) // expect: 120
}

fun getFactorialWithMutual(n: Int): Int = trampoline(getFactorialWithMutual(n, 1))

fun getFactorialWithMutual(n: Int, left: Int): Bounce<Int> = when (n) {
  0 -> Done(left)
  else -> More { getFactorialWithMutual(n - 1, n * left) }
}
