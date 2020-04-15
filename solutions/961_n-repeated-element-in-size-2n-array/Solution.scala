package main

import scala.annotation.tailrec

object Solution1:
  def repeatedNTimes(a: Array[Int]): Int = 
    var i = 0
    while (i < a.size)
      var j = 1
      while (j < 4 && j + i < a.size)
        if (a(i) == a(i + j))
          return a(i)
        j += 1
      i += 1
    throw IllegalArgumentException("a repeated element must exist")

object Solution2:
  def isValid(v: Vector[Int], i: Int): Int =
    @tailrec
    def check(j: Int = 1): Int = 
      if (j >= 4) 
        -1
      else if (i + j < v.size && v(i) == v(i + j))
        v(i)
      else
        check(j + 1)
    check()

  @tailrec
  def traverse(v: Vector[Int], i: Int = 0): Int =
    if (i >= v.size)
      throw IllegalArgumentException("a repeated element must exist")
    isValid(v, i) match
      case -1 => traverse(v, i + 1)
      case x  => x

  def repeatedNTimes(v: Vector[Int]): Int = 
    traverse(v)

object Solution3:
  def isValid(v: Vector[Int], i: Int): Option[Int] =
    @tailrec
    def check(j: Int = 1): Option[Int] =
      if (j >= 4)
        None
      else if (i + j < v.size && v(i) == v(i + j))
        Some(v(i))
      else
        check(j + 1)
    check()

  @tailrec
  def traverse(v: Vector[Int], i: Int = 0): Int =
    if (i >= v.size)
      throw IllegalArgumentException("a repeated element must exist")
    isValid(v, i) match
      case None    => traverse(v, i + 1)
      case Some(x) => x

  def repeatedNTimes(v: Vector[Int]): Int =
    traverse(v)

object Solution4:
  def isValid(v: Vector[Int], i: Int): Option[Int] =
    @tailrec
    def check(j: Int = 1): Option[Int] =
      if (j >= 4)
        None
      else if (v.lift(i + j) == Some(v(i)))
        Some(v(i))
      else
        check(j + 1)
    check()

  @tailrec
  def traverse(v: Vector[Int], i: Int = 0): Int =
    if (i >= v.size)
      throw IllegalArgumentException("a repeated element must exist")
    isValid(v, i) match
      case None    => traverse(v, i + 1)
      case Some(x) => x

  def repeatedNTimes(v: Vector[Int]): Int =
    traverse(v)

object Solution5:
  def isValid(v: Vector[Int], i: Int): Option[Int] =
    @tailrec
    def check(j: Int = 1): Option[Int] =
      if (j >= 4)
        None
      else if (v.lift(i + j).map(_ == v(i)).getOrElse(false))
        Some(v(i))
      else
        check(j + 1)
    check()

  @tailrec
  def traverse(v: Vector[Int], i: Int = 0): Int =
    if (i >= v.size)
      throw IllegalArgumentException("a repeated element must exist")
    isValid(v, i) match
      case None    => traverse(v, i + 1)
      case Some(x) => x

  def repeatedNTimes(v: Vector[Int]): Int =
    traverse(v)

object Solution6:
  def repeatedNTimes(v: Vector[Int]): Int = 
    val slides = v.sliding(4) ++ (2 to 3).map(v.takeRight(_))
    val resOpt = slides.find(s => s.tail.contains(s.head))
    resOpt match
      case Some(r +: _) => r
      case Some(_) | None => throw IllegalArgumentException("a repeated element must exist")
