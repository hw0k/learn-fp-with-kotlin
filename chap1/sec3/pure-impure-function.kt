fun main() {
  println(impureFunction(1, 2))
  sideEffectFunction(3, 10)
  println(impureFunction(1, 2))
}

var z = 3

// 비순수 함수: 참조 불투명
fun impureFunction(x: Int, y: Int): Int = x + y + z

// 비순수 함수: 사이드 이펙트
fun sideEffectFunction(x: Int, y: Int) {
  z = x + y
}
