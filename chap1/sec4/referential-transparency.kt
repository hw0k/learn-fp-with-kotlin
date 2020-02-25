var anonymous = "Joe"

// 참조 불투명 + 사이드 이펙트
fun hello1() {
  println("Hello $anonymous")
}

// 사이드 이펙트
fun hello2(name: String) {
  println("Hello $name")
}

// 순수 함수와 사이드 이펙트 함수의 분리
fun getHelloString(name: String): String {
  return "Hello $name"
}

fun printStringToConsole(string: String) {
  println(string)
}

fun main() {
  val helloString = getHelloString("John Doe")
  printStringToConsole(helloString)
}
