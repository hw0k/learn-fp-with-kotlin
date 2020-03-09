fun main() {
  println(powerWithTailrec(3.0, 3)) // expect: 27.0
  println(powerWithTailrec(4.0, 2)) // expect: 16.0
  
  println(powerWithTailrec(2.0, 4) == powerWithTailrec(2.0, 3) * 2.0) // expect: true
}

fun powerWithTailrec(x: Double, n: Int): Double = powerWithTailrec(x, n, x)

tailrec fun powerWithTailrec(x: Double, n: Int, left: Double): Double = when {
  n == 0 -> 1.0
  n == 1 -> left
  else -> powerWithTailrec(x, n - 1, x * left)
}
