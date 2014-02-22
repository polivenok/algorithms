Implementation of well known algorithms in scala for learning purposes.

**[Sorting algorithms](http://www.sorting-algorithms.com/)**

Implmentation uses scala implicits to add sorting methods to List (in case if algorithm works with immutable data structures in a fucntional way) and Array (in case of usual imperative style with mutable data structures).

Check `SortingExtensions` object for details

* Insertion sort
* Merge sort
* Quick sort


Test written in scala test using property based testing. To run tests execute

 `sbt test`

To run main execute

 `sbt run`



