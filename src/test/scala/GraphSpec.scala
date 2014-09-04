import graph.{Path, Edge, Graph}
import org.scalatest.{Matchers, FlatSpec}

class GraphSpec extends FlatSpec  with Matchers {

  val graph = new Graph(Edge("1", "2", 3.5), Edge("2", "3", 4), Edge("1", "3", 4))

  "An Graph" should  "find elements using BFS" in {
    graph.BFS("3") shouldBe true
  }

  it should "find elements using DFS" in {
    graph.DFS("3") shouldBe true
  }

  it should "compute shortest distance" in {
    graph.Dijkstra("1") should contain ("3" -> Path(4.0, List("1", "3")))
  }

}
