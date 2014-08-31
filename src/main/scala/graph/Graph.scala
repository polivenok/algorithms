package graph

import scala.collection.mutable
import scala.collection.mutable.Stack

case class Edge(from: String, to: String, weight: Double)

case class Vertex(id: String) {
  var connectedTo: Map[String, Double] = Map()

  def addNeighbor(neighbor: String, weight: Double = 0) {
    connectedTo += (neighbor -> weight)
  }

  def connections = connectedTo.keys

  override def toString: String = s"$id connected to ${connectedTo.keySet}"
}

class Graph(edges: Edge*) {
  var vertices_ : Map[String, Vertex] = Map()
  edges.foreach(addEdge)


  def addVertex(key: String) {
    vertices_ += (key -> Vertex(key))
  }

  def addEdge(edge: Edge) {
    if (!vertices_.contains(edge.from)) vertices_ += (edge.from -> Vertex(edge.from))
    if (!vertices_.contains(edge.to)) vertices_ += (edge.to -> Vertex(edge.to))
    vertices_(edge.from).addNeighbor(edge.to, edge.weight)
  }

  def vertices = vertices_.values.toList

  def contains(node: String): Boolean = vertices_.contains(node)

  case class DiscoverableVertex(vertex: Vertex, var discovered: Boolean)

  def DFS(id: String):Boolean = {
    val stack = mutable.Stack(DiscoverableVertex(vertices.head, discovered = false))
    while(stack.nonEmpty){
      val vd = stack.pop()
      if(vd.vertex.id == id) return true
      if(!vd.discovered){
        vd.discovered = true
        vd.vertex.connections.foreach(id => stack.push(DiscoverableVertex(vertices_(id), discovered = false)))
      }
    }
    false
  }

  def BFS(id: String): Boolean = {
    val queue = mutable.Queue(DiscoverableVertex(vertices.head, discovered = false))
    while(queue.nonEmpty){
      val vd = queue.dequeue()
      if(vd.vertex.id == id) return true
      if(!vd.discovered){
        vd.discovered = true
        vd.vertex.connections.foreach(id => queue.enqueue(DiscoverableVertex(vertices_(id), discovered = false)))
      }
    }
     false
  }

  override def toString: String = vertices_.values.map(_.toString).mkString("\n")

}
