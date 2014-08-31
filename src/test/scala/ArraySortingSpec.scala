import org.scalatest._
import prop._

import sorting.SortingExtensions._

class ArraySortingSpec extends PropSpec with Checkers {

  property("Sorted using insertions sort") {
    check((a: Array[Int]) => a.insertionSort.sameElements(a.sorted))
  }

  property("Sorted using quick sort") {
    check((a: Array[Int]) => a.quickSort.sameElements(a.sorted))
  }

}
