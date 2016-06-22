package exercises.scala.testClass

/**
  * Created by awerner on 20/06/2016.
  */
class Person(val name: String, val age: Int)

class Child (name: String, age: Int, val parents: List[Person]) extends Person(name, age)

object Program extends App {
  val john = new Person("John", 24)
  val jill = new Person("Jill", 37)

  val baby = new Child("lily", 2, List(john, jill))

  println(john.name + " : " + john.age)
  println(jill.name + " : " + jill.age)

  println(baby.name + " has two parents: " + baby.parents.head.name + " & " + baby.parents(1).name)
}
