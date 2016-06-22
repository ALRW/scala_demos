package solutions.scala.reductions

object Program {
  def main(args : Array[String]) = {
    val numbers = List(1,2,3,4,5,6,7,8,9,10)
    def sumViaReduce() {
      println(numbers.reduce(_ + _))
    }
    def countViaReduce() {
      println(numbers.foldLeft(0)((sum,x) => sum + 1))
    }
    def averageViaReduce() {
      def sum = numbers.reduce(_ + _)
      def count = numbers.foldLeft(0)((sum,x) => sum + 1)
      println(sum / count)
    }
    def lastViaReduce() {
      println(numbers.reduce((a,b) => b))
    }
    def penultimateViaReduce() {
      println(numbers.foldLeft((0,0))((a,b) => (a._2,b))._1)
    }
    def reverseViaReduce() {
      val reversed = numbers.foldLeft(List[Int]())(_:+_)
      reversed.foreach(printf("%s ",_))
      println
    }
    sumViaReduce
    countViaReduce
    averageViaReduce
    lastViaReduce
    penultimateViaReduce
    reverseViaReduce
  }
}
