Implementation of well known algorithms in scala for learning purposes.

Tests are written in scala test using property based testing. To run tests execute

 `sbt test`

#### [Sorting algorithms](http://www.sorting-algorithms.com/)

Implementation uses scala implicits to add sorting methods to List (in case if algorithm works with immutable data structures in a functional way) and Array (in case of usual imperative style with mutable data structures).

Check `SortingExtensions` object for details

* [Insertion sort](http://www.sorting-algorithms.com/insertion-sort)
* [Merge sort](http://www.sorting-algorithms.com/merge-sort)
* [Quick sort](http://www.sorting-algorithms.com/quick-sort)

#### Tree structure

* [Binary Search Tree](http://en.wikipedia.org/wiki/Binary_search_tree).
Check `BinarySearchTree` class for very simple implementation with traverse and contains methods. 

#### Useful online resources 
 1. [Coursera, Algorithms: Design and Analysis from Standford](https://www.coursera.org/course/algo), [Part2](https://www.coursera.org/course/algo2)  
 2. [MIT, Introduction to Algorithms](http://ocw.mit.edu/courses/electrical-engineering-and-computer-science/6-046j-introduction-to-algorithms-sma-5503-fall-2005/video-lectures/)
 3. [Algorithmist](http://www.algorithmist.com/)
 4. [Algorithms, by by Robert Sedgewick and Kevin Wayne](http://algs4.cs.princeton.edu/)
 5. [Elementary Algorithms and Data structures](https://github.com/liuxinyu95/AlgoXY)
 5. [Functional Data Structures in Scala](https://github.com/vkostyukov/scalacaster/)

