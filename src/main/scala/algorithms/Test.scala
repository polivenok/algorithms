package algorithms

import sorting.SortingExtensions._

object Test {

  def main(args: Array[String]) {
    println(List(3,2,7,1,12).mergeSort)
    println(Array(-1, 0, 393287367, 1) .mergeSort.mkString(" "))
    println(Array(-1, 0, 0, 1610612736, 1102816150, 2147483647) .mergeSort.sameElements(Array(-1, 0, 0, 1610612736, 1102816150, 2147483647).sorted))
  }
}
