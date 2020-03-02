fun main() {
  println(elem(2, listOf(1, 2, 3))) // expect: true
  println(elem(9, listOf(7, 5, 2))) // expect: false 
}

fun elem(num: Int, list: List<Int>): Boolean = when {
  list.isEmpty() -> false
  num == list.first() -> true
  else -> elem(num, list.drop(1))
}
