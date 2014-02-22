package algorithms.sorting

object SortingExtensions {

  /**
   * Sorting algorithms using functional programming principles and immutable data structures (list)
   * @param list original list
   * @tparam T type
   */
  implicit class ListExtendedSorting[T](val list: List[T]) extends AnyVal {

    /**
     * Based on [[http://www.sorting-algorithms.com/insertion-sort]]
     * @param ord
     * @tparam B
     * @return
     */
    def insertionSort[B >: T](implicit ord: Ordering[B]): List[T] = {
      def insert(listAcc: List[T], el: T) = {
        val (h, t) = listAcc.span(ord.lt(_, el))
        h ::: (el :: t)
      }

      list.foldLeft(List[T]()) {
        (acc, el) => insert(acc, el)
      }
    }

    /**
     * Based on [[http://www.sorting-algorithms.com/merge-sort]]
     * @param ord
     * @tparam B
     * @return
     */
    def mergeSort[B >: T](implicit ord: Ordering[B]): List[T] = {
      def merge(left: List[T], right: List[T]): List[T] = (left, right) match {
        case (Nil, x) => right
        case (x, Nil) => left
        case (leftHead :: leftTail, rightHead :: rightTail) =>
          if (ord.lt(leftHead, rightHead)) leftHead :: merge(leftTail, right)
          else rightHead :: merge(left, rightTail)
      }
      if (list.size <= 1) list
      else {
        val (left, right) = list.splitAt(list.size / 2)
        merge(left.mergeSort(ord), right.mergeSort(ord))
      }
    }

    /**
     * Based on [[http://www.scala-lang.org/docu/files/ScalaByExample.pdf]] and
     * [[http://www.sorting-algorithms.com/quick-sort]]
     * @param ord
     * @tparam B
     * @return
     */
    def quickSort[B >: T](implicit ord: Ordering[B]): List[T] = {
      if (list.size <= 1) list
      else {
        val pivot = list(list.length / 2)
        list.filter(ord.lt(_, pivot)).quickSort(ord) ::: list.filter(pivot ==) ::: list.filter(ord.gt(_, pivot)).quickSort(ord)
      }
    }
  }

  /**
   * Sorting algorithms using usual imperative programming and mutable data structures (array)
   * @param array original array
   * @tparam T type
   */
  implicit class ArrayExtendedSorting[T](val array: Array[T]) extends AnyVal {

    /**
     * Based on [[http://www.sorting-algorithms.com/insertion-sort]]
     * @param ord
     * @tparam B
     * @return
     */
    def insertionSort[B >: T](implicit ord: math.Ordering[B]): Array[T] = {
      for (i <- 1 until array.size) {
        val key = array(i)
        var j = i - 1
        while (j >= 0 && ord.gt(array(j), key)) {
          array(j + 1) = array(j)
          j = j - 1
          array(j + 1) = key
        }
      }
      array
    }

    /**
     * Based on [[http://www.sorting-algorithms.com/merge-sort]]
     * @param ord
     * @tparam B
     * @return
     */
    def mergeSort[B >: T](implicit ord: math.Ordering[B]): Array[T] = {
      def merge(start: Int, mid: Int, end: Int) {
        var i = 0
        var j = mid + 1
        var k = 0
        val temp = array.slice(0, mid + 1)
        while (i <= mid && j <= end) {
          if (ord.lt(array(j), temp(i))) {
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
     * @param ord
     * @tparam B
     * @return
     */
    def quickSort[B >: T](implicit ord: math.Ordering[B]): Array[T] = {
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
          while (ord.lt(array(i), pivot)) i += 1
          while (ord.gt(array(j), pivot)) j -= 1
          if (i <= j) {
            swap(i, j)
            i += 1
            j -= 1
          }
        }
        if (left < j) sort(left, j)
        if (j < right) sort(i, right)
      }
      if (!array.isEmpty) sort(0, array.length - 1)
      array

    }
  }

}

