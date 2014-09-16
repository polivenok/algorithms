object Knapsack {

  case class Item(weight: Int, value: Int)

  /**
   * Solves knapsack problem using dynamic programming
   * @param items list of items
   * @param maxWeight max weight
   * @return max value
   */
  def packItems(items: List[Item], maxWeight: Int): Int = {
    val n = items.size
    val m = Array.ofDim[Int](n + 1, maxWeight + 1)
    for (i <- 1 to n) {
      for (j <- 0 to maxWeight) {
        val wi = items(i - 1).weight
        m(i)(j) = {
          if (wi > j) m(i - 1)(j)
          else math.max(m(i - 1)(j), m(i - 1)(j - wi) + items(i - 1).value)
        }
      }
    }

    m(n)(maxWeight)
  }

}

