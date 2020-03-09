fun main() {
  println(toBinaryWithTailrec(0)) // expect: 1
  println(toBinaryWithTailrec(1)) // expect: 1
  println(toBinaryWithTailrec(2)) // expect: 10
  println(toBinaryWithTailrec(5)) // expect: 101
  println(toBinaryWithTailrec(15)) // expect: 1111
  println(toBinaryWithTailrec(16)) // expect: 10000
  println(toBinaryWithTailrec(24)) // expect: 11000
  println(toBinaryWithTailrec(25)) // expect: 11001
}

tailrec fun toBinaryWithTailrec(n: Int, acc: String = ""): String = when {
  n < 2 -> acc + n.toString()
  else -> toBinaryWithTailrec(n / 2, acc + (n % 2))
}
