object Solution:
  def largestNumber(nums: Array[Int]): String =
    val numsSorted = nums.sortWith { (n1, n2) =>
      val s1 = n1.toString
      val s2 = n2.toString
      s1 + s2 > s2 + s1
    }

    if (numsSorted.isEmpty)
      throw new IllegalArgumentException()
    else if (numsSorted.head == 0)
      "0"
    else
      numsSorted.mkString("")
