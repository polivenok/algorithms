import org.scalatest._
import prop._

import algorithms.sorting.SortingExtensions._

class ArraySortingSpec extends PropSpec with Checkers {

  property("Sorted using insertions sort") {
    check((a: Array[Int]) => a.insertionSort.sameElements(a.sorted))
  }

  property("Sorted using merge sort") {
    check((a: Array[Int]) => a.mergeSort.sameElements(a.sorted))
  }


}
