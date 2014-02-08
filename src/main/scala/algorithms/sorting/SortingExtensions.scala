package algorithms.sorting

object SortingExtensions{

  implicit class ListExtendedSorting[T](val list:List[T]) extends AnyVal{

    def insertionSort[B >: T](implicit ord: Ordering[B]): List[T] = {
      def insert(listAcc: List[T], el: T) = {
        val (h, t) = listAcc.span(ord.lt(_, el))
        h ::: (el :: t)
      }

     list.foldLeft(List[T]()) {(acc, el) => insert(acc, el)}
    }
  }

  implicit class ArrayExtendedSorting[T](val array:Array[T]) extends AnyVal{

    def insertionSort[B >: T](implicit ord: math.Ordering[B]): Array[T] = {
      for(i <- 1 until array.size) {
        val key = array(i)
        var j = i - 1
        while(j >= 0 && ord.gt(array(j), key)){
          array(j + 1) = array(j)
          j = j - 1
          array(j + 1) = key
        }
      }
      array
    }
  }
}

