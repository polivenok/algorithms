import org.scalatest.{Matchers, FlatSpec}

class SchedulerSpec extends FlatSpec with Matchers{

  val simpleJobs = List((48, 14), (4, 90), (64, 22), (54, 66), (46, 6))

  "Weighted Shortest Processing Time (WSPT) (jobs ordered by job length/ job weight)" should "return an optimal minimal value" in {
    Scheduler.WSPT(simpleJobs) shouldBe 10548
  }

}
