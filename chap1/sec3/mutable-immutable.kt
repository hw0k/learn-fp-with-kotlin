fun main() {
  val mutablePerson = MutablePerson("변하는 남현욱", 20)
  println(addAgeToPerson(mutablePerson, 1))
  println(mutablePerson)

  val immutablePerson = ImmutablePerson("변하지 않는 남현욱", 20)
  println(getAgedPerson(immutablePerson, 1))
  println(immutablePerson)
}

// 변경 가능한 객체 프로퍼티
data class MutablePerson(var name: String, var age: Int)

// 인자로 들어온 객체의 프로퍼티 수정
fun addAgeToPerson(person: MutablePerson, age: Int): MutablePerson {
  person.age += age
  return person
}

// 변하지 않는 프로퍼티
data class ImmutablePerson(val name: String, val age: Int)

// 새로운 객체 생성 후 반환
fun getAgedPerson(person: ImmutablePerson, age: Int): ImmutablePerson {
  return ImmutablePerson(person.name, person.age + age)
}
