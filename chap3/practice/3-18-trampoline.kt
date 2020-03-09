sealed class Bounce<T>
data class Done<T>(val result: T): Bounce<T>()
data class More<T>(val thunk: () -> Bounce<T>): Bounce<T>()

tailrec fun <T> trampoline(bounce: Bounce<T>): T = when (bounce) {
  is Done -> bounce.result
  is More -> trampoline(bounce.thunk())
}
