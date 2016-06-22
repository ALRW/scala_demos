package demos.scala.pyramid

import scala.io.StdIn

object PyramidOne {
  def main(args : Array[String]) {
    println("Enter the height of the pyramid...")
    val heightString = StdIn.readLine()
    val height = Integer.parseInt(heightString)

    var numHashes = 1
    for(i <- 1 to height) {
      val numSpaces = height - i
      for(x <- 1 to numSpaces) {
        print(" ")
      }
      for(x <- 1 to numHashes) {
        print("#")
      }
      numHashes += 2
      println()
    }
  }
}