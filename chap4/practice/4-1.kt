fun main() {
  val condition: (Int) -> Boolean = { it in 1..3 }
  val body: (Int) -> String = {
    when (it) {
      1 -> "One!"
      2 -> "Two!"
      3 -> "Three!"
      else -> throw IllegalArgumentException()
    }
  }

  val oneTwoThree = body.toPartialFunction(condition)

  when {
    oneTwoThree.isDefinedAt(5) -> {
      print(oneTwoThree(5))
    }
    else -> {
      print("isDefinedAt(x) return false")
    }
  }
}

class PartialFunction<P, R>(
  private val condition: (P) -> Boolean,
  private val f: (P) -> R
) : (P) -> R {
  fun isDefinedAt(p: P): Boolean = condition(p)

  override fun invoke(p: P): R = when {
    condition(p) -> f(p)
    else -> throw IllegalArgumentException("$p isn't supported.")
  }
  fun invokeOrElse(p: P, default: R): R = when {
    condition(p) -> f(p)
    else -> default
  }
  fun orElse(p: P, that: PartialFunction<P, R>): PartialFunction<P, R> = when {
    condition(p) -> this
    else -> that
  }
}

fun <P, R> ((P) -> R).toPartialFunction(definedAt: (P) -> Boolean) : PartialFunction<P, R> = PartialFunction(definedAt, this)
