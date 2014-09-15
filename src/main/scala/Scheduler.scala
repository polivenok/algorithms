object Scheduler {

  /**
   * Weighted Shortest Processing Time (WSPT).
   * Jobs ordered by job length / job weight.
   * @param jobs list of (job weight, job length)
   * @return  sum of weighted shortest processing time
   */
  def WSPT(jobs: List[(Int, Int)]): Long = {
    val sortedJobs = jobs.map { case (weight, jobLength) => (weight, jobLength, jobLength.toDouble / weight.toDouble)}.sortBy(_._3)
    var sum: Long = 0
    var totalLength = 0
    for ((weight, jobLength, _) <- sortedJobs) {
      totalLength = totalLength + jobLength
      sum = sum + weight * totalLength
    }
    sum
  }

}
