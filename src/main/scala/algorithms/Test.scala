package algorithms

import algorithms.sorting.SortingExtensions._
import algorithms.tree.immutable.BinarySearchTree

object Test {

  def main(args: Array[String]) {
    println(List(3,2,7,1,12).quickSort)
    println(Array(-1, 0, 393287367, 1) .quickSort.mkString(" "))
    println(BinarySearchTree(5, 3, 2, 0).sorted)

  }
}
