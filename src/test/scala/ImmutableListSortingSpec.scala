import org.scalatest._
import prop._

import sorting.SortingExtensions._

class ImmutableListSortingSpec extends PropSpec with Checkers {

  property("Sorted using insertions sort") {
    check((a: List[Int]) => a.insertionSort == a.sorted)
  }

  property("Sorted using merge sort") {
    check((a: List[Int]) => a.mergeSort == a.sorted)
  }

  property("Sorted using quick sort") {
    check((a: List[Int]) => a.quickSort == a.sorted)
  }


}
