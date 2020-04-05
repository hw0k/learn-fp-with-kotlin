package io.humanscape.fpkotlin

import io.humanscape.fpkotlin.FunList.*

/**
 * FunList<T>는 Nil 혹은 Cons<T>가 된다.
 */

sealed class FunList<out T> {
  object Nil : FunList<Nothing>()
  data class Cons<out T>(val head: T, val tail: FunList<T>) : FunList<T>()
}

fun <T> funListOf(vararg elements: T): FunList<T> = elements.toFunList()

private fun <T> Array<out T>.toFunList(): FunList<T> = when {
  this.isEmpty() -> FunList.Nil
  else -> FunList.Cons(this[0], this.copyOfRange(1, this.size).toFunList())
}

fun <T> FunList<T>.addHead(head: T): FunList<T> = FunList.Cons(head, this)

tailrec fun <T> FunList<T>.appendTail(value: T, acc: FunList<T> = Nil): FunList<T> = when (this) {
  FunList.Nil -> Cons(value, acc).reverse()
  is FunList.Cons -> tail.appendTail(value, acc.addHead(head))
}

tailrec fun <T> FunList<T>.reverse(acc: FunList<T> = Nil): FunList<T> = when (this) {
  FunList.Nil -> acc
  is FunList.Cons -> tail.reverse(acc.addHead(head))
}

fun <T> FunList<T>.getTail(): FunList<T> = when (this) {
  FunList.Nil -> throw NoSuchElementException()
  is FunList.Cons -> tail
}

/**
 * 5-3: 리스트의 첫번째 값을 가져오는 getHead 함수를 작성해 보자.
 */
fun <T> FunList<T>.getHead(): T = when (this) {
  FunList.Nil -> throw NoSuchElementException()
  is FunList.Cons -> head
}

fun <T> FunList<T>.filter(acc: FunList<T> = FunList.Nil, p: (T) -> Boolean): FunList<T> = when (this) {
  FunList.Nil -> acc.reverse()
  is FunList.Cons -> if (p(head)) {
    tail.filter(acc.addHead(head), p)
  } else {
    tail.filter(acc, p)
  }
}

/**
 * 5-4: 리스트에서 앞의 n개의 값을 제외한 리스트를 반환하는 drop 함수를 구현하자.
 * 이때 원본 리스트가 바뀌지 않고, 새로운 리스트를 반환할때 리스트를 매번
 * 생성하지 않고, 한번만 생성해야 한다.
 */
tailrec fun <T> FunList<T>.drop(n: Int): FunList<T> = when {
  n == 0 -> this
  else -> when (this) {
    FunList.Nil -> this
    is FunList.Cons -> tail.drop(n - 1)
  }
}

/**
 * 5-5: 다음과 같이 동작하는 dropWhile 함수를 구현하자. 타입 T를 입력받아
 * Boolean을 반환하는 함수 p를 입력받는다. 리스트의 앞에서부터
 * 함수 p를 만족하기 전까지 drop을 하고, 나머지 값들의 리스트를 반환한다.
 * 이때 원본 리스트가 바뀌지 않고, 새로운 리스트를 반환할 때 매번 리스트를
 * 생성하지 않아야 한다.
 */
tailrec fun <T> FunList<T>.dropWhile(p: (T) -> Boolean): FunList<T> = when (this) {
  FunList.Nil -> this
  is FunList.Cons -> when {
    p(head) -> this
    else -> tail.dropWhile(p)
  }
}

/**
 * 5-6: 리스트의 앞에서부터 n개의 값을 가진 리스트를 반환하는 take 함수를
 * 구현하자. 이때 원본 리스트가 바뀌지 않고, 새로운 리스트를 반환할때 매번
 * 리스트를 생성하지 않아야 한다.
 */
tailrec fun <T> FunList<T>.take(n: Int, acc: FunList<T> = Nil): FunList<T> = when {
  n == 0 -> acc
  else -> when (this) {
    FunList.Nil -> acc
    is FunList.Cons -> tail.take(n - 1, acc.appendTail(head))
  }
}

/**
 * 5-7: 다음과 같이 동작하는 takeWhile 함수를 구현하자. 타입 T를 입력받아
 * Boolean을 반환하는 함수 p를 받는다. 리스트의 앞에서부터 함수 p를 만족하는
 * 값들의 리스트를 반환한다.(모든 값이 함수 p를 만족하지 않는다면 원본 List를 반환).
 * 이때 원본 리스트가 바뀌지 않고, 새로운 리스트를 반환할 때 매번 리스트를 생성하지
 * 않아야 한다.
 */
tailrec fun <T> FunList<T>.takeWhile(acc: FunList<T> = Nil, p: (T) -> Boolean): FunList<T> = when (this) {
  FunList.Nil -> acc
  is FunList.Cons -> if (p(head)) {
    tail.takeWhile(acc.appendTail(head), p)
  } else {
    tail.takeWhile(acc, p)
  }
}

tailrec fun <T, R> FunList<T>.map(acc: FunList<R> = Nil, f: (T) -> R): FunList<R> = when (this) {
  FunList.Nil -> acc.reverse()
  is FunList.Cons -> tail.map(acc.addHead(f(head)), f)
}

/**
 * 5-8: 앞서 작성한 map 함수에서 고차함수가 값들의 순서값(인덱스)값도
 * 같이 받아올 수 있는 indexedMap 함수를 만들자.
 */
tailrec fun <T, R> FunList<T>.indexedMap(index: Int = 0, acc: FunList<R> = Nil, f: (Int, T) -> R): FunList<R> = when (this) {
  FunList.Nil -> acc.reverse()
  is FunList.Cons -> tail.indexedMap(index + 1, acc.addHead(f(index, head)), f)
}

val list: FunList<Int> = Cons(1, Cons(2, Cons(3, Nil)))

/**
 * 5-1: FunList를 사용해서 [1, 2, 3, 4, 5]를 가지는 intList를 생성하자.
 */
val intList: FunList<Int> = Cons(1, Cons(2, Cons(3, Cons(4, Cons(5, Nil)))))

/**
 * 5-2: FunList를 사용해서 [1.0, 2.0, 3.0, 4.0, 5.0]을 가지는 doubleList를 생성하자.
 */
val doubleList: FunList<Double> = Cons(1.0, Cons(2.0, Cons(3.0, Cons(4.0, Cons(5.0, Nil)))))

fun main() {
  val intList = Cons(1, Cons(2, Cons(3, Nil)))

  // 5-3
  require(intList.getHead() == 1)

  // 5-4
  require(intList.drop(1) == funListOf(2, 3))
  require(intList.drop(2) == funListOf(3))
  require(intList.drop(3) == Nil)
  require(intList.drop(4) == Nil)

  // 5-5
  val intList2 = Cons(1, Cons(2, Cons(3, Cons(4, Nil))))
  require(intList2.dropWhile { it % 2 == 0 } == funListOf(2, 3, 4))
  require(intList2.dropWhile { it > 3 } == funListOf(4))
  require(intList2.dropWhile { it > 5 } == Nil)

  // 5-6
  val intList3 = Cons(1, Cons(2, Cons(3, Nil)))
  require(intList3.take(0) == Nil)
  require(intList3.take(1) == funListOf(1))
  require(intList3.take(2) == funListOf(1, 2))
  require(intList3.take(3) == funListOf(1, 2, 3))
  require(intList3.take(4) == funListOf(1, 2, 3))

  // 5-7
  val intList4 = Cons(1, Cons(2, Cons(3, Cons(4, Nil))))
  require(intList4.takeWhile { it < 4 } == funListOf(1, 2, 3))
  require(intList4.takeWhile { it < 2 } == funListOf(1))
  require(intList4.takeWhile { it < 0 } == Nil)

  // 5-8
  val intList5 = Cons(1, Cons(2, Cons(3, Nil)))
  require(intList5.indexedMap { index, elm -> index * elm } == funListOf(0, 2, 6))
}
