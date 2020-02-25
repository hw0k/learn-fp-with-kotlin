fun main() {
  val simpleCalculator = SimpleCalculator()
  println(simpleCalculator.calculate('+', 5, 1))
  println(simpleCalculator.calculate('-', 6, 3))

  val plus = OOPCalculator(PlusExecutor())
  val minus = OOPCalculator(MinusExecutor())
  println(plus.calculate(5, 1))
  println(minus.calculate(6, 3))

  println(calculate(plusFunction, 5, 1))
  println(calculate(minusFunction, 6, 3))
}
                                                                                                                                                                                                                                                                                                                                 
// 명령형

class SimpleCalculator {
  fun calculate(op: Char, num1: Int, num2: Int): Int = when {
    num1 > num2 && num2 != 0 -> when {
      op == '+' -> num1 + num2
      op == '-' -> num1 - num2
      else -> throw IllegalArgumentException()
    }
    else -> throw IllegalArgumentException()
  }
}

// OOP

interface CalculateExecutor {
  fun execute(num1: Int, num2: Int): Int
}

class PlusExecutor : CalculateExecutor {
  override fun execute(num1: Int, num2: Int): Int {
    return num1 + num2
  }
}

class MinusExecutor : CalculateExecutor {
  override fun execute(num1: Int, num2: Int): Int {
    return num1 - num2
  }
}

class OOPCalculator(private val executor: CalculateExecutor) {
  fun calculate(num1: Int, num2: Int): Int = when {
    num1 > num2 && num2 != 0 -> executor.execute(num1, num2)
    else -> throw IllegalArgumentException()
  }
}

// FP

typealias CalculatorFunction = (num1: Int, num2: Int) -> Int

val plusFunction: CalculatorFunction = { num1, num2 -> num1 + num2 }
val minusFunction: CalculatorFunction = { num1, num2 -> num1 - num2 }

fun calculate(calculator: CalculatorFunction, num1: Int, num2: Int): Int = when {
  num1 > num2 && num2 != 0 -> calculator(num1, num2)
  else -> throw IllegalArgumentException()
}
