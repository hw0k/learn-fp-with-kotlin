fun main() {
  println(getFactorialWithMemo(0)) // expect: 1
  println(getFactorialWithMemo(1)) // expect: 1
  println(getFactorialWithMemo(2)) // expect: 2
  println(getFactorialWithMemo(3)) // expect: 6
  println(getFactorialWithMemo(4)) // expect: 24
  println(getFactorialWithMemo(5)) // expect: 120
}

var memo = Array(100, { -1 })

fun getFactorialWithMemo(n: Int): Int = when {
  n == 0 -> 1
  memo[n] != -1 -> memo[n]
  else -> {
    println("debug: getFactorialWithMemo with $n")
    memo[n] = n * getFactorialWithMemo(n - 1)
    memo[n]
  }
}
