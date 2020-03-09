fun main() {
  println(listOf(1, 2, 3).powerset()) // expect: 집합 S = {1, 2, 3}의 멱집합 P(S)
}

fun <T> Collection<T>.powerset(): Set<Set<T>> = powerset(this, setOf(setOf()))

tailrec fun <T> powerset(s: Collection<T>, acc: Set<Set<T>>): Set<Set<T>> = when {
  s.isEmpty() -> acc
  else -> powerset(s.drop(1), acc + acc.map { it + s.first() })
}
