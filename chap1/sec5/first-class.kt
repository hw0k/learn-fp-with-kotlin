/*
 * 일급 객체
 * 
 * 객체가 함수의 매개변수로 가능
 * 객체가 함수의 반환값으로 가능
 * 객체가 변수나 자료구조에 할당 가능
 * 
 * 대표적인 Kotlin의 일급 객체에는 Any가 있음.
 */


fun any1(any: Any) {
  //
}

fun any2(): Any {
  return Any()
}

var anyList: List<Any> = listOf(Any())


/*
 * Kotlin은 함수도 일급 객체임. 따라서 일급 함수!
 */

fun func1(func: (Int) -> String) {
  //
}

fun func2(): (Int) -> String {
  return { value -> value.toString() }
}

var funcList: List<(Int) -> String> = listOf({ value -> value.toString() })
