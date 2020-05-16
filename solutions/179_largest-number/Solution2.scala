import scala.annotation.tailrec

case class Number(value: Int, digits: Vector[Int])

object Solution:
  @tailrec
  def extractDigits(n: Int, digits: Vector[Int] = Vector.empty): Vector[Int] =
    if (n == 0)
      if (digits.isEmpty)
        Vector(0)
      else
        digits.reverse
    else
      extractDigits(n / 10, digits :+ (n % 10))

  def compareNumbers(n1: Number, n2: Number): Boolean =
    if (n1.value == n2.value)
      false
    else
      @tailrec
      def loop(idx: Int = 0): Boolean =
        if (idx < n1.digits.size + n2.digits.size)
          val v1 = if (idx < n1.digits.size) n1.digits(idx) else n2.digits(idx - n1.digits.size)
          val v2 = if (idx < n2.digits.size) n2.digits(idx) else n1.digits(idx - n2.digits.size)
          if (v1 != v2)
            v1 > v2
          else
            loop(idx + 1)
        else
          false

      loop()

  def largestNumber(nums: Array[Int]): String =
    val numbers = nums.toVector.map { n => Number(value = n, digits = extractDigits(n)) }
    val numbersSorted = numbers.sortWith(compareNumbers)

    if (numbersSorted.isEmpty)
      throw new IllegalArgumentException()
    else if (numbersSorted.head.value == 0)
      "0"
    else
      numbersSorted.map(_.value).mkString("")
