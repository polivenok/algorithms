package algorithms

import sorting.SortingExtensions._

object Test {

  def main(args: Array[String]) {
    println(List(3,2,7,1,12).insertionSort)
    println(Array(3,2,7,1,12).insertionSort.mkString(" "))
  }
}
