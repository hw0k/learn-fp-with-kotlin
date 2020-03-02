fun main() {
  println(toBinary(0)) // expect: 1
  println(toBinary(1)) // expect: 1
  println(toBinary(2)) // expect: 10
  println(toBinary(5)) // expect: 101
  println(toBinary(15)) // expect: 1111
  println(toBinary(16)) // expect: 10000
  println(toBinary(24)) // expect: 11000
  println(toBinary(25)) // expect: 11001
}

fun toBinary(n: Int): String = when {
  n < 2 -> n.toString()
  else -> toBinary(n / 2) + n % 2
}
