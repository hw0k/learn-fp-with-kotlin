fun main() {
  println(max(1)(2))   // expect: 2
  println(max(4)(7))   // expect: 7
  println(max(3)(-1))  // expect: 3
  println(max(9)(9))   // expect: 9
  println(max(0)(8))   // expect: 8
}

val max = {
  left: Int -> {
    right: Int -> when {
        left >= right -> left
        else -> right
    }
  }
}
