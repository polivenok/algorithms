package graph

case class Edge[T](from: T, to: T, weight: Double)

case class Vertex[T](id: T) {
  var connectedTo: Map[T, Double] = Map()

  def addNeighbor(neighbor: T, weight: Double = 0) {
    connectedTo += (neighbor -> weight)
  }

  def connections = connectedTo.keys

  override def toString: String = s"$id connected to ${connectedTo.keySet}"
}

class Graph[T](edges: Edge[T]*) {
  var vertices_ : Map[T, Vertex[T]] = Map()
  edges.foreach(addEdge)


  def addVertex(key: T) {
    vertices_ += (key -> Vertex(key))
  }

  def addEdge(edge: Edge[T]) {
    if (!vertices_.contains(edge.from)) vertices_ += (edge.from -> Vertex(edge.from))
    if (!vertices_.contains(edge.to)) vertices_ += (edge.to -> Vertex(edge.to))
    vertices_(edge.from).addNeighbor(edge.to, edge.weight)
  }

  def vertices = vertices_.values.toList

  def BFS(node: T): Boolean = {
    false
  }

  def DFS(node: T): Boolean = {
    false
  }

  override def toString: String = vertices_.values.map(_.toString).mkString("\n")

}
