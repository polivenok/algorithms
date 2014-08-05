import algorithms.tree.BinarySearchTree
import org.scalatest.{Matchers, FlatSpec}

class TreeSpec extends FlatSpec with Matchers {

  val tree = new BinarySearchTree[Int](List(6, 9, 2, 1, 5))

  "A Binary Search Tree" should "sort values in order" in {
    tree.sorted shouldBe List(1, 2, 5, 6, 9)
  }

  it should "find existing value" in {
    tree.exists(1) shouldBe true
  }

  it should  "not find existing value" in {
    tree.exists(100) shouldBe false
  }



}
