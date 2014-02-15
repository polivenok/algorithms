package algorithms.sorting

object SortingExtensions {

  /**
   * Sorting algorithms using functional programming principles and immutable data structures (list)
   * @param list original list
   * @tparam T type
   */
  implicit class ListExtendedSorting[T](val list: List[T]) extends AnyVal {

    def insertionSort[B >: T](implicit ord: Ordering[B]): List[T] = {
      def insert(listAcc: List[T], el: T) = {
        val (h, t) = listAcc.span(ord.lt(_, el))
        h ::: (el :: t)
      }

      list.foldLeft(List[T]()) {
        (acc, el) => insert(acc, el)
      }
    }

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
  }

  /**
   * Sorting algorithms using usual imperative programming and mutable data structures (array)
   * @param array original array
   * @tparam T type
   */
  implicit class ArrayExtendedSorting[T](val array: Array[T]) extends AnyVal {

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

    def mergeSort[B >: T](implicit ord: math.Ordering[B]): Array[T] = {
      def merge(start: Int, mid: Int, end: Int) {
        var i = 0
        var j = mid + 1
        var k = 0
        val temp = array.slice(0, mid + 1)
        while (i <= mid && j <= end) {
          if (ord.lt(array(j), temp(i))) {
            array(k) = array(j)
            j = j + 1
          } else {
            array(k) = temp(i)
            i = i + 1
          }
          k = k + 1
        }
        while (i <= mid) {
          array(k) = temp(i)
          k = k + 1
          i = i + 1
        }
      }
      def mergeSort(start: Int, end: Int) {
        if (end <= start) return
        val mid = start + (end - start) / 2
        mergeSort(start, mid)
        mergeSort(mid + 1, end)
        merge( start, mid, end)
      }
      mergeSort(0, array.length - 1)
      array
    }
  }

}

