package exercises.scala.Program

/**
  * Created by awerner on 21/06/2016.
  */
class MyClass {
  def operation1(str: String) = {
    println("This is a great String: " + str)
  }
  def ::::(str: String) = {
    println("This is quite possibly the best string I've ever seen: " + str)
  }
}

object Program extends App{

  val a = new MyClass

  val b = a.operation1("Hello")

  val c = a operation1 "goodbye"

  val d = a.::::("Hello again")

  val e = "what? " :::: a

}
