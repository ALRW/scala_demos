package demos.scala.lambdas.basic

import scala.util.Properties.propOrNone

object Program {
  def showLambdasWithRanges {
    println("---Demo 1---")
    val limit = 6
    (1 to limit).foreach(num => printf("%d ", num))
    println
    (1 to limit).foreach(printf("%d ", _))
    println("\n\n")
  }
  def showLambdasWithLists {
    println("---Demo 2 ---")
    val data = List(10, 11, 12, 13, 14, 15)
    printf("Items are: ")
    data.foreach(printf("%d ", _))
    println

    val filteredData = data.filter(_ % 2 == 0)
    printf("Filtered items are: ")
    filteredData.foreach(printf("%d ", _))
    println

    val result1 = data.foldLeft(1000)((a, b) => a + b)
    val result2 = data.foldLeft(2000)(_ + _)
    printf("Results of folding are %d and %d\n", result1, result2)
    println("\n")
  }
  def showLambdasWithRegex {
    println("---Demo 3 ---")
    val text = "abc123def456ghi789"
    val regex = "[a-z]{3}".r

    printf("Matches are: ")
    regex.findAllIn(text).foreach(printf("%s ", _))
    println

    val newText = regex.replaceAllIn(text, _.group(0).toUpperCase())
    printf("Text after replacing matches is: %s\n", newText)
    println("\n")
  }
  def showLambdasWithOption = {
    def printProperty(name : String) {
      propOrNone(name).foreach(printf("Property '%s' has value %s\n", name, _))
    }
    println("---Demo 4 ---")
    printProperty("java.version")
    printProperty("java.wibble")
  }
  def main(args : Array[String]) {
    showLambdasWithRanges
    showLambdasWithLists
    showLambdasWithRegex
    showLambdasWithOption
  }
}