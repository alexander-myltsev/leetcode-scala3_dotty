import scala.annotation.tailrec

object Solution
  def sqr(x: Int): Int = x * x

  @tailrec
  def process(a: Vector[Int], idxL: Int, idxR: Int,
              res: Vector[Int], idx: Int): Vector[Int] =
    if (idxL <= idxR)
      if (-a(idxL) < a(idxR))
        process(a, idxL, idxR - 1, res.updated(idx, sqr(a(idxR))), idx - 1)
      else
        process(a, idxL + 1, idxR, res.updated(idx, sqr(a(idxL))), idx - 1)
    else
      res

  def sortedSquares(a: Array[Int]): Array[Int] =
    val res = process(a=a.toVector, idxL=0, idxR=a.length - 1,
                      Vector.fill(a.length)(0), a.length - 1)
    res.toArray
