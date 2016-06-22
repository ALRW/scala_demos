package exercises.scala.pyramid

import scala.io.StdIn

object Pyramid {
  def main(args : Array[String]) {
    println("Enter the height of the pyramid...")
    val heightString = StdIn.readLine()
    val height = Integer.parseInt(heightString)



    println("Here is a pyramid of height " + height)


      var s = height
      var h = 1
      var acc = 1
      while(acc < height){
        printLine(s, h)
        h += 2
        s -= 1
        acc += 1
      }


    def printLine(spaces: Int, hashes: Int) {
      println(" " * spaces + "#" * hashes + " " * spaces)
     }


  }
}