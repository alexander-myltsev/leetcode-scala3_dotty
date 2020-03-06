object Solution
  def repeatedNTimes(a: Array[Int]): Int = 
    var i = 0
    while (i < a.size)
      var j = 1
      while (j < 4 && j + i < a.size)
        if (a(i) == a(i + j))
          return a(i)
        j += 1
      i += 1
    throw new IllegalArgumentException("a repeated element must exist")
