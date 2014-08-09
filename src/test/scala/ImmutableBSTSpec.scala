import algorithms.tree.immutable.BinarySearchTree
import org.scalatest.{FlatSpec, Matchers}

class ImmutableBSTSpec extends FlatSpec with Matchers {

  val tree = BinarySearchTree(6, 9, 2, 1, 5)

  "An Immutable Binary Search Tree" should "sort values in order" in {
    tree.sorted shouldBe List(1, 2, 5, 6, 9)
  }

  it should "find value which is present in a tree" in {
    tree.contains(1) shouldBe true
  }

  it should  "not find value which is not present in a tree" in {
    tree.contains(100) shouldBe false
  }
}
