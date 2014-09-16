import Knapsack.Item
import org.scalatest.{Matchers, FlatSpec}

class KnapsackSpec  extends FlatSpec with Matchers{

  "Knapsack solver" should "return an max value of items which can be packed" in {
    Knapsack.packItems(List(Item(4, 3), Item(3, 2), Item(2, 4), Item(3, 4)), 6) shouldBe 8
  }

}
