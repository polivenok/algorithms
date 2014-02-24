Implementation of well known algorithms in scala for learning purposes.

Tests are written in scala test using property based testing. To run tests execute

 `sbt test`

#### [Sorting algorithms](http://www.sorting-algorithms.com/)

Implmentation uses scala implicits to add sorting methods to List (in case if algorithm works with immutable data structures in a fucntional way) and Array (in case of usual imperative style with mutable data structures).

Check `SortingExtensions` object for details

* [Insertion sort](http://www.sorting-algorithms.com/insertion-sort)
* [Merge sort](http://www.sorting-algorithms.com/merge-sort)
* [Quick sort](http://www.sorting-algorithms.com/quick-sort)

#### Useful Resources 
 1. [Coursera, Algorithms: Design and Analysis from Standford](https://www.coursera.org/course/algo), [Part2](https://www.coursera.org/course/algo2)  
 2. [MIT, Introduction to Algorithms](http://ocw.mit.edu/courses/electrical-engineering-and-computer-science/6-046j-introduction-to-algorithms-sma-5503-fall-2005/video-lectures/)
 3. [Algorithmist](http://www.algorithmist.com/)
 4. [Algorithms, by by Robert Sedgewick and Kevin Wayne](http://algs4.cs.princeton.edu/)
