import scala.annotation.tailrec

object Solution:

  opaque type InfinityInt = Option[Int]
  val infinityInt: Option[Int] = None
  def fromInt(v: Int): InfinityInt = Some(v)

  extension optionOps on (n: InfinityInt):
    def greater(v: Int): Boolean =
      n.map(_ > v).getOrElse(true)

    def eql(v: Int): Boolean =
      n.map(_ == v).getOrElse(false)

    def geq(v: Int): Boolean =
      n.eql(v) || n.greater(v)

  @tailrec
  private def traverse(numsV: Vector[Int],
                       n1: InfinityInt = infinityInt,
                       n2: InfinityInt = infinityInt): Boolean =
    numsV match
      case Vector() => false
      case v +: vs if (n1.geq(v)) => traverse(vs, fromInt(v), n2)
      case v +: vs if (n2.geq(v)) => traverse(vs, n1, fromInt(v))
      case _ => true

  def increasingTriplet(nums: Array[Int]): Boolean =
    traverse(nums.toVector)

@main def run() =
  import Solution.increasingTriplet
  assert(increasingTriplet(Array(1, 2, 3, 4, 5)) == true)
  assert(increasingTriplet(Array(5, 4, 3, 2, 1)) == false)
  assert(increasingTriplet(Array(1, 1, 1, 1, 1)) == false)
