fun main() {
  println(replicate(3, 5)) // expect: [5, 5, 5]
  println(replicate(10, 2)) // expect: [10, 10]
  println(replicate(6, 3).reduce { sum, elem -> sum + elem }) // expect: 18 
}

fun replicate(n: Int, element: Int): List<Int> = when {
  n == 0 -> listOf()
  else -> listOf(element) + replicate(n - 1, element)
}
