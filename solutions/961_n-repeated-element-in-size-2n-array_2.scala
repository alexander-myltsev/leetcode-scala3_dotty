object Solution
  def repeatedNTimes(a: Array[Int]): Int = 
    val v = a.toVector
    val slides = v.sliding(4) ++ (2 to 3).map(v.takeRight(_))
    val resOpt = slides.find(s => s.tail.contains(s.head))
    resOpt match
      case Some(r +: _) => r
      case Some(_) => ??? // never happens
      case None => 
        throw IllegalArgumentException("a repeated element must exist")
