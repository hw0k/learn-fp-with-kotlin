fun main() {
  println(takeSequence(5, repeat(3))) // expect: [3, 3, 3, 3, 3]
}

fun repeat(n: Int): Sequence<Int> = sequenceOf(n) + { repeat(n) }

fun takeSequence(n: Int, sequence: Sequence<Int>): List<Int> = when {
  n <= 0 -> listOf()
  sequence.none() -> listOf()
  else -> sequence.take(1).toList() + takeSequence(n - 1, sequence)
}

// Supporting code

operator fun <T> Sequence<T>.plus(other: () -> Sequence<T>) = object : Sequence<T> {
  private val thisIterator: Iterator<T> by lazy { this@plus.iterator() }
  private val otherIterator: Iterator<T> by lazy { other().iterator() }

  override fun iterator() = object : Iterator<T> {
    override fun next(): T =
      if (thisIterator.hasNext()) thisIterator.next()
      else otherIterator.next()
    
    override fun hasNext(): Boolean = thisIterator.hasNext() || otherIterator.hasNext()
  }
}
