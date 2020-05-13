import scala.annotation.tailrec

object Solution
  def sqr(x: Int): Int = x * x

  @tailrec
  def merge(l: Vector[Int], res: Vector[Int]): Vector[Int] = l match
    case Vector() => res
    case Vector(x) => sqr(x) +: res
    case v =>
      val neg +: back = v
      val front :+ pos = v
      if -neg > pos then
        merge(back, sqr(neg) +: res)
      else
        merge(front, sqr(pos) +: res)

  def sortedSquares(a: Array[Int]): Array[Int] =
    val res = merge(a.toVector, Vector.empty)
    res.toArray
