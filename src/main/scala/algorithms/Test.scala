package algorithms

import sorting.SortingExtensions._

object Test {

  def main(args: Array[String]) {
    println(List(3,2,7,1,12).quickSort)
    println(Array(-1, 0, 393287367, 1) .quickSort.mkString(" "))
  }
}
