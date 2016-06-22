package exercises.scala.collections

import exercises.scala.collections.CourseType._

object Program {
  val dave = Trainer("Dave Jones", 500.0, List("UNIX, Linux"))
  val jane = Trainer("Jane Smith", 750.0, List("SQL","Java","JEE"))
  val pete = Trainer("Pete Hughes", 1000.0, List("Java", "JEE", "C#", "Scala"))
  val mary = Trainer("Mary Donaghy", 1250.0, List("Java", "JEE", "C#", "C++"))
  val courses = List(Course("AB12","Intro to Scala",BEGINNER,4,List(pete)),
                     Course("CD34","JEE Web Development",INTERMEDIATE,3,List(pete, mary, jane)),
                     Course("EF56","Meta-Programming in Ruby",ADVANCED,2,List()),
                     Course("GH78","OO Design with UML",BEGINNER,3,List(jane,pete,mary)),
                     Course("IJ90","Database Access with JPA",INTERMEDIATE,3, List(jane)),
                     Course("KL12","Design Patterns in C#",ADVANCED,2, List(pete,mary)),
                     Course("MN34","Relational Database Design",BEGINNER,4, List(jane)),
                     Course("OP56","Writing MySql Stored Procedures",INTERMEDIATE,1, List(jane)),
                     Course("QR78","Patterns of Parallel Programming",ADVANCED,2, List(pete,mary)),
                     Course("ST90","C++ Programming for Beginners",BEGINNER,5,List(mary)),
                     Course("UV12","UNIX Threading with PThreads",INTERMEDIATE,2,List()),
                     Course("WX34","Writing Linux Device Drivers",ADVANCED,3,List(mary)))

  def main(args: Array[String]) = {
    def titlesOfCourses(): Unit = {
      courses.foreach(c => println(c.title))
      println("-------")
    }
    def titlesOfCoursesWithoutATrainer(): Unit = {
      courses.foreach(c => if(c.instructors.isEmpty) println(c.title))
      println("-------")
    }
    def namesAndRatesOfTrainers(): Unit = {
      val inst = courses.flatMap(_.instructors).distinct
      inst.foreach(i => println(i.name + " : " + i.rate))
      println("-------")
    }
    def theNumberOfAdvancedCourses(): Unit = {
      val advanced = courses.filter(_.courseType == ADVANCED)
      println(advanced.length)
      println("-------")
    }

    def totalDurationsOfBeginnerAndNonBeginnerCourses(): Unit = {

      val bc = courses.filter(c => c.courseType == BEGINNER)
      val bcTime = bc.foldLeft(0)(_ + _.duration)
      val nonBc = courses.filter(c => c.courseType == INTERMEDIATE || c.courseType == ADVANCED)
      val nonBcTime = nonBc.foldLeft(0)(_ + _.duration)
      println("Beginner time: " + bcTime)
      println("Intermediate & advanced time: " + nonBcTime)
      println("-------")
    }

    def everyPairOfTrainersThatCouldDeliverJava(): Unit = {
      courses.flatMap(_.instructors)
        .distinct
        .filter(_.skills.contains("Java"))
        .map(_.name)
        .combinations(2)
        .foreach(list => printf("%s and %s\n", list(0), list(1)))

      println("-------")
    }
    def possibleCostsOfJeeWebDevelopment(): Unit = {
      val course = courses.find(_.title == "JEE Web Development")
      val duration = course.map(_.duration)
        .getOrElse(0)
      course.foreach(_.instructors
        .map(p => (p.name, p.rate * duration))
        .foreach(println))
      println("----------")
    }
    def coursesIdsAndTitlesGroupedByType(): Unit = {
      def process(row: (CourseType.Value, List[Course])): Unit = {
        println(row._1)
        row._2.foreach(c => printf("\t%s %s\n", c.id, c.title))
      }
      courses.groupBy(_.courseType)
        .foreach(process)
    }
    titlesOfCourses
    titlesOfCoursesWithoutATrainer
    namesAndRatesOfTrainers
    totalDurationsOfBeginnerAndNonBeginnerCourses
    everyPairOfTrainersThatCouldDeliverJava
    possibleCostsOfJeeWebDevelopment
    coursesIdsAndTitlesGroupedByType
  }
}
