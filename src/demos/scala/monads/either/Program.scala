package demos.scala.monads.either

import scala.collection.Iterator
import scala.io.Source

object Program {
  def fileContent(path : String) : Either[String,Iterator[String]] = {
    try {
      Right(Source.fromFile(path).getLines())
    } catch {
      case ex : Exception => Left(ex.getMessage)
    }
  }
  def main(args: Array[String]) = {
    fileContent("input.txt") match {
      case Left(s) => println("Whoops: " + s)
      case Right(iter) => iter.foreach(println)
    }
  }
}
