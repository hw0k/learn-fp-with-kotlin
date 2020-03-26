fun main() {
  println(max(1)(2))
  println(max(4)(7))
  println(max(3)(-1))
  println(max(9)(9))
  println(max(0)(8))
}

fun max(left: Int) = {
  right: Int -> {
    when {
      left >= right -> left
      else -> right
    }
  }
}
