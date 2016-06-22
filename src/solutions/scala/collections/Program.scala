package solutions.scala.collections

import CourseType._

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
    def titlesOfCourses() {
      println("Titles of courses:")
      courses.map(_.title)
             .foreach(println)
      println("---")
    }

    def titlesOfCoursesWithoutATrainer() {
      println("Titles of courses without a trainer:")
      courses.filter(_.instructors.isEmpty)
             .map(_.title)
             .foreach(println)
      println("---")
    }
    def namesAndRatesOfTrainers() {
      println("Names and rates of trainers:")
      courses.flatMap(_.instructors)
             .map(t => (t.name,t.rate))
             .foreach(println)
      println("---")
    }
    def theNumberOfAdvancedCourses() {
      println("The number of advanced courses")
      println(courses.count(_.courseType == ADVANCED))
      println("---")
    }
    def totalDurationsOfBeginnerAndNonBeginnerCourses() {
      println("Total days for both beginner and non-beginner courses")
      val splitCourses = courses.partition(_.courseType == BEGINNER)
      val beginnerDuration = splitCourses._1.map(_.duration).sum
      val nonBeginnerDuration = splitCourses._2.map(_.duration).sum
      println((beginnerDuration,nonBeginnerDuration))
      println("---")
    }
    def everyPairOfTrainersThatCouldDeliverJava() {
      println("Pairs of trainers that could deliver Java")
      courses.flatMap(_.instructors)
             .distinct
             .filter(_.skills.contains("Java"))
             .map(_.name)
             .combinations(2)
             .foreach(list => printf("%s and %s\n",list(0),list(1)))
      println("---")
    }
    def possibleCostsOfJeeWebDevelopment() {
      println("Possible costs of 'JEE Web Development'")
      val course = courses.find(_.title == "JEE Web Development")
      val duration = course.map(_.duration)
                           .getOrElse(0)
      course.foreach(_.instructors
                      .map(p => (p.name, p.rate * duration))
                      .foreach(println))
      println("---")
    }
    def coursesIdsAndTitlesGroupedByType() {
      def process(row: (CourseType.Value, List[Course])) {
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
