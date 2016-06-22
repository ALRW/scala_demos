package exercises.scala.partials
import scala.io.Source

object Program {
 def main(args : Array[String]) {



  def processLines(fn: (String) => Boolean)(filename: String) = {
   val input = Source.fromFile(filename)
   for(line <- input.getLines){
    if(fn(line)) println(line)
   }
  }

  def processTwo(fn: (String) => Boolean)(filename: String) = {
   Source.fromFile(filename).getLines.foreach(f => if(fn(f)) println(f))
  }

   val f1 = processLines(line => line.endsWith("36"))_
   val f2 = processLines(line => line.startsWith("200"))_
   val f3 = processLines(line => line.matches("^19[5-8]{1}.+"))_

   f1("input.txt")
   f2("input.txt")
   f3("input.txt")

 }
}
