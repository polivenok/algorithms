package graph

import scala.collection.mutable

case class Edge(from: String, to: String, weight: Double)

case class Vertex(id: String) {
  var connectedTo: Map[String, Double] = Map()

  def addNeighbor(neighbor: String, weight: Double = 0) {
    connectedTo += (neighbor -> weight)
  }

  def lengthTo(id: String) = connectedTo(id)

  def connections = connectedTo.keys

  override def toString: String = s"$id connected to ${connectedTo.keySet}"
}


case class Path(length: Double, path: List[String])

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

  def DFS(id: String): Boolean = {
    val stack = mutable.Stack(DiscoverableVertex(vertices.head, discovered = false))
    while (stack.nonEmpty) {
      val vd = stack.pop()
      if (vd.vertex.id == id) return true
      if (!vd.discovered) {
        vd.discovered = true
        vd.vertex.connections.foreach(id => stack.push(DiscoverableVertex(vertices_(id), discovered = false)))
      }
    }
    false
  }

  def BFS(id: String): Boolean = {
    val queue = mutable.Queue(DiscoverableVertex(vertices.head, discovered = false))
    while (queue.nonEmpty) {
      val vd = queue.dequeue()
      if (vd.vertex.id == id) return true
      if (!vd.discovered) {
        vd.discovered = true
        vd.vertex.connections.foreach(id => queue.enqueue(DiscoverableVertex(vertices_(id), discovered = false)))
      }
    }
    false
  }

  /**
   * Find shortest paths from source to all connected vertices.
   * @param source id of vertex
   * @return map with key representing vertex id, and value as shortest distance and path to it.
   *
   */
  //TODO: Optimize to use heaps for finding min
  def Dijkstra(source: String): Map[String, Path] = {
    val distances = mutable.HashMap[String, Double]()
    val previous = mutable.HashMap[String, String]()
    var buffer = mutable.HashMap[Vertex, Double]()

    for ((id, vertex) <- vertices_) {
      val distance = if (id == source) 0 else Double.MaxValue
      buffer(vertex) = distance
      distances(id) = distance
    }

    while (buffer.nonEmpty) {
      val (vertex, distance) = buffer.minBy(_._2)
      buffer -= vertex
      for (neighbor <- vertex.connections) {
        val alt = distance + vertex.lengthTo(neighbor)
        if (alt < distances(neighbor)) {
          previous(neighbor) = vertex.id
          distances(neighbor) = alt
          buffer(Vertex(neighbor)) = alt
        }
      }
    }
    calculatePath(source, previous, distances)
  }

  /**
   * Transforms source vertex, shortest distances, and map with previous vertices into more readable format
   *
   * @param source
   * @param previous
   * @param distances
   * @return map with target vertex id and Path to it from source
   */
  private def calculatePath(source: String, previous: mutable.HashMap[String, String], distances: mutable.HashMap[String, Double]): Map[String, Path] = {
    var pathMap =  mutable.HashMap[String, Path]()
    for(id <- vertices_.keySet) {
      var target = id
      var list = List[String]()
      while (previous.contains(target)) {
        list = target :: list
        target = previous(target)
      }
      list = source :: list
      pathMap += (id -> Path(distances(id), list))
    }
    pathMap.toMap
  }

  override def toString: String = vertices_.values.map(_.toString).mkString("\n")

}
