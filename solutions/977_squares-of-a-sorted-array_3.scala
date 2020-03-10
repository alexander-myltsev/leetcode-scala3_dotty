object Solution
  def sqr(x: Int): Int = x * x

  def merge(neg: List[Int], pos: List[Int]): List[Int] = (neg, pos) match
    case (Nil, xs) => xs.map(sqr)
    case (xs, Nil) => xs.map(sqr)
    case (n :: ns, p :: ps) =>
      if -n > p then
        sqr(n) :: merge(ns, pos)
      else
        sqr(p) :: merge(neg, ps)

  def sortedSquares(a: Array[Int]): Array[Int] =
    val l = a.toList
    val pos = l.filter(_ >= 0)
    val neg = l.filter(_ < 0)
    val res = merge(neg, pos.reverse)
    res.reverse.toArray
