import graph.{Edge, Graph}

import scala.collection.mutable

object Test {
  def main(args: Array[String]) {
//    println(List(3,2,7,1,12).quickSort)
//    println(Array(-1, 0, 393287367, 1) .quickSort.mkString(" "))
//    println(BinarySearchTree(5, 3, 2, 0).sorted)

   // println(new Graph(Edge("1", "2", 3.5), Edge("2", "3", 4)).BFS("3"))

   // val pq = mutable.PriorityQueue(4, 5 ,3, 7)(Ordering[Int].reverse)
    println(new Graph(Edge("1", "2", 3.5), Edge("2", "3", 4), Edge("1", "3", 4)).Dijkstra("1"))
  }
}
