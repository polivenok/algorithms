Implementation of well known algorithms in scala for learning purposes.

Basic cases are covered with unit tests. To run tests execute

 `sbt test`

#### [Sorting algorithms](http://www.sorting-algorithms.com/)

[Implementation](https://github.com/polivenok/algorithms/blob/master/src/main/scala/sorting/SortingExtensions.scala) uses scala implicits to add sorting methods to List (in case if algorithm works with immutable data structures in a functional way) and Array (in case of usual imperative style with mutable data structures).

* [Insertion sort](http://www.sorting-algorithms.com/insertion-sort)
* [Merge sort](http://www.sorting-algorithms.com/merge-sort)
* [Quick sort](http://www.sorting-algorithms.com/quick-sort)

#### Tree structure

* [Binary Search Tree](http://en.wikipedia.org/wiki/Binary_search_tree). [Mutable](https://github.com/polivenok/algorithms/blob/master/src/main/scala/tree/mutable/BinarySearchTree.scala) and [immutable and functional-like](https://github.com/polivenok/algorithms/blob/master/src/main/scala/tree/immutable/BinarySearchTree.scala).

#### [Graphs](http://en.wikipedia.org/wiki/Graph_%28abstract_data_type%29). 

[Graph structure represented by Adjacency list with implementation of the following algorithms:](https://github.com/polivenok/algorithms/blob/master/src/main/scala/graph/Graph.scala)

* [BFS](http://en.wikipedia.org/wiki/Breadth-first_search)
* [DFS](http://en.wikipedia.org/wiki/Depth-first_search)
* [Dijkstra](http://en.wikipedia.org/wiki/Dijkstra%27s_algorithm)

#### [Scheduling](http://riot.ieor.berkeley.edu/Applications/Scheduling/algorithms.html)
* [Weighted Shortest Processing Time](https://github.com/polivenok/algorithms/blob/master/src/main/scala/Scheduler.scala)

#### Useful online resources 
 1. [Coursera, Algorithms: Design and Analysis from Standford](https://www.coursera.org/course/algo), [Part2](https://www.coursera.org/course/algo2)  
 2. [MIT, Introduction to Algorithms](http://ocw.mit.edu/courses/electrical-engineering-and-computer-science/6-046j-introduction-to-algorithms-sma-5503-fall-2005/video-lectures/)
 3. [Algorithmist](http://www.algorithmist.com/)
 4. [Algorithms, by by Robert Sedgewick and Kevin Wayne](http://algs4.cs.princeton.edu/)
 5. [Elementary Algorithms and Data structures](https://github.com/liuxinyu95/AlgoXY)
 5. [Functional Data Structures in Scala](https://github.com/vkostyukov/scalacaster/)

