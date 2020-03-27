fun main() {
  val isLessThanThree = { i: Int -> i < 200 }
  val list = listOf(1, 2, 3, 4, 5, 201, 202)

  println(takeWhile(isLessThanThree, list)) // expect: [1, 2, 3, 4, 5]

  val sequence = generateSequence(1) { it + 1 }
  
  println(takeWhile(isLessThanThree, sequence)) // expect: [1...199]
}

tailrec fun <T> takeWhile(
  func: (T) -> Boolean,
  list: List<T>,
  acc: List<T> = listOf()
): List<T> {
  val cur = list.first()
  val isEnd = !(func(cur))
  return when {
    list.isEmpty() || isEnd -> acc
    else -> takeWhile(func, list.drop(1), acc + listOf(cur))
  }
}

tailrec fun <T> takeWhile(
  func: (T) -> Boolean,
  sequence: Sequence<T>,
  acc: List<T> = listOf()
): List<T> {
  val cur = sequence.first()
  val isEnd = !(func(cur))

  return when {
    sequence.none() || isEnd -> acc
    else -> takeWhile(func, sequence.drop(1), acc + listOf(cur))
  }
}
