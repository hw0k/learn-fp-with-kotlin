fun main() {
  println(replicateWithTailrec(3, 5)) // expect: [5, 5, 5]
  println(replicateWithTailrec(10, 2)) // expect: [10, 10]
  println(replicateWithTailrec(6, 3).reduce { sum, elem -> sum + elem }) // expect: 18 
}

tailrec fun replicateWithTailrec(n: Int, element: Int, acc: List<Int> = listOf()): List<Int> = when {
  n == 0 -> acc
  else -> replicateWithTailrec(n - 1, element, listOf(element) + acc)
}
