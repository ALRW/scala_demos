package exercises.scala.reductions

object Program {
   def main(args : Array[String]) = {
     val numbers = List(1,2,3,4,5,6,7,8,9,10)
     def sumViaReduce() = numbers.reduce(_ + _)

     def countViaReduce() = {
        numbers.foldLeft(0)((a,b) => a + 1)
     }
     def averageViaReduce() = {
       sumViaReduce / countViaReduce
     }
     def lastViaReduce() = {
       numbers(countViaReduce -1)
     }
     def penultimateViaReduce() = {
       numbers(countViaReduce - 2)
     }
     def reverseViaReduce() = {
       numbers.foldLeft(List[Int]())((r,c) => c +: r)


     }
     println(sumViaReduce())
     println(countViaReduce())
     println(averageViaReduce())
     println(lastViaReduce())
     println(penultimateViaReduce())
     print(reverseViaReduce())


   }
 }
