package demos.scala.monads.trying

import scala.collection.Iterator
import scala.io.Source
import scala.util.{Success, Failure, Try}

object Program {
   def fileContent(path : String) : Try[Iterator[String]] = {
     Try(Source.fromFile(path).getLines())
   }
   def firstLine(path : String) : Try[String] = {
     Try(Source.fromFile(path).getLines().next())
   }
   def main(args: Array[String]) = {
     demoV1("input.txt")
     demoV1("false.txt")
     demoV2("input.txt")
     demoV2("false.txt")
     demoV3("path.txt")
     demoV3("false.txt")
   }

  def demoV1(path : String) = {
    println("--------")
    fileContent(path) match {
      case Failure(ex) => println("Whoops: " + ex.getMessage)
      case Success(iter) => iter.foreach(println)
    }
  }
  def demoV2(path : String) = {
    println("--------")
    val iter = fileContent(path).getOrElse(Iterator("Sorry"))
    iter.foreach(println)
  }
  def demoV3(path : String) = {
    println("--------")
    val content = for {
      data1 <- firstLine(path)
      data2 <- fileContent(data1)
    } yield data2

    val iter = content.getOrElse(Iterator("Sorry"))
    iter.foreach(println)
  }
}
