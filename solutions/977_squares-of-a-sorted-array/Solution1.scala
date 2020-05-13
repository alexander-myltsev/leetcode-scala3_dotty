object Solution
  def sqr(x: Int): Int = x * x

  def sortedSquares(a: Array[Int]): Array[Int] =
    var idxL = 0
    var idxR = a.length - 1
    var idx = idxR
    val res = Array.ofDim[Int](a.length)

    while (idxL <= idxR)
      if (-a(idxL) < a(idxR))
        res(idx) = sqr(a(idxR))
        idxR -= 1
      else
        res(idx) = sqr(a(idxL))
        idxL += 1
      idx -= 1

    res
