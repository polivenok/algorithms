package sorting

object SortingExtensions {

  /**
   * Sorting algorithms using functional programming principles and immutable data structures (list)
   * @param list original list
   * @tparam T type
   */
  implicit class ListExtendedSorting[T <% Ordered[T]](val list: List[T])  {

    /**
     * Based on [[http://www.sorting-algorithms.com/insertion-sort]]
     * @return
     */
    def insertionSort[B >: T]: List[T] = {
      def insert(listAcc: List[T], el: T) = {
        val (h, t) = listAcc.span(_ < el)
        h ::: (el :: t)
      }

      list.foldLeft(List[T]()) {
        (acc, el) => insert(acc, el)
      }
    }

    /**
     * Based on [[http://www.sorting-algorithms.com/merge-sort]]
     * @return
     */
    def mergeSort[B >: T]: List[T] = {
      def merge(left: List[T], right: List[T]): List[T] = (left, right) match {
        case (Nil, x) => right
        case (x, Nil) => left
        case (leftHead :: leftTail, rightHead :: rightTail) =>
          if (leftHead < rightHead) leftHead :: merge(leftTail, right)
          else rightHead :: merge(left, rightTail)
      }
      if (list.size <= 1) list
      else {
        val (left, right) = list.splitAt(list.size / 2)
        merge(left.mergeSort, right.mergeSort)
      }
    }

    /**
     * Based on [[http://www.scala-lang.org/docu/files/ScalaByExample.pdf]] and
     * [[http://www.sorting-algorithms.com/quick-sort]]
     * @return
     */
    def quickSort[B >: T]: List[T] = {
      if (list.size <= 1) list
      else {
        val pivot = list(list.length / 2)
        list.filter(_ < pivot).quickSort ::: list.filter(_ == pivot) ::: list.filter(_ > pivot).quickSort
      }
    }
  }

  /**
   * Sorting algorithms using usual imperative programming and mutable data structures (array)
   * @param array original array
   * @tparam T type
   */
  implicit class ArrayExtendedSorting[T <% Ordered[T]](val array: Array[T]) {

    /**
     * Based on [[http://www.sorting-algorithms.com/insertion-sort]]
     * @return
     */
    def insertionSort[B >: T]: Array[T] = {
      for (i <- 1 until array.size) {
        val key = array(i)
        var j = i - 1
        while (j >= 0 && array(j) > key) {
          array(j + 1) = array(j)
          j = j - 1
          array(j + 1) = key
        }
      }
      array
    }

    /**
     * Based on [[http://www.sorting-algorithms.com/merge-sort]]
     * @return
     */
    def mergeSort[B >: T]: Array[T] = {
      def merge(start: Int, mid: Int, end: Int) {
        var i = 0
        var j = mid + 1
        var k = 0
        val temp = array.slice(0, mid + 1)
        while (i <= mid && j <= end) {
          if (array(j) < temp(i)) {
            array(k) = array(j)
            j += 1

          } else {
            array(k) = temp(i)
            i += 1

          }
          k += 1
        }
        while (i <= mid) {
          array(k) = temp(i)
          k += 1
          i += 1
        }
      }
      def mergeSort(start: Int, end: Int) {
        if (end <= start) return
        val mid = start + (end - start) / 2
        mergeSort(start, mid)
        mergeSort(mid + 1, end)
        merge(start, mid, end)
      }
      mergeSort(0, array.length - 1)
      array
    }

    /**
     * Based on [[http://www.scala-lang.org/docu/files/ScalaByExample.pdf]] and
     * [[http://www.sorting-algorithms.com/quick-sort]]
     * @return
     */
    def quickSort[B >: T]: Array[T] = {
      def swap(i: Int, j: Int) {
        val temp = array(i)
        array(i) = array(j)
        array(j) = temp
      }
      def sort(left: Int, right: Int) {
        val pivot = array((left + right) / 2)
        var i = left
        var j = right
        while (i <= j) {
          while (array(i) < pivot) i += 1
          while (array(j) > pivot) j -= 1
          if (i <= j) {
            swap(i, j)
            i += 1
            j -= 1
          }
        }
        if (left < j) sort(left, j)
        if (j < right) sort(i, right)
      }
      if (array.nonEmpty) sort(0, array.length - 1)
      array

    }
  }

}

