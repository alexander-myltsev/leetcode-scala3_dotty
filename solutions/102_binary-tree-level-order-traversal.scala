import scala.annotation.tailrec

class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null):
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right

case class Tree(value: Int, left: Option[Tree], right: Option[Tree]):
  def isLeaf: Boolean = left.isEmpty && right.isEmpty

object Solution:
  def convert(n: TreeNode): Option[Tree] =
    Option(n).map { n =>
      Tree(value = n.value, left = convert(n.left), right = convert(n.right))
    }

  def convert(n: Option[Tree]): TreeNode =
    n.map { n =>
      val tn = new TreeNode(n.value)
      tn.left = convert(n.left)
      tn.right = convert(n.right)
      tn
    }.orNull

  @tailrec
  def extract_new_level(level: Vector[Tree],
                        new_level: Vector[Tree] = Vector(),
                        result: Vector[Int] = Vector()): (Vector[Tree], Vector[Int]) =
    level match
      case Vector() => (new_level, result)
      case t +: ts =>
        val r1_n = new_level ++ t.left ++ t.right // NOTE: `Option` is handled as `Iterable`
        val r2_n = result :+ t.value
        extract_new_level(ts, r1_n, r2_n)

  @tailrec
  def traverse_level(level: Vector[Tree],
                     result: Vector[Vector[Int]]): Vector[Vector[Int]] =
    if (level.isEmpty)
      result
    else
      val (r1, r2) = extract_new_level(level)
      traverse_level(r1, result :+ r2)

  def levelOrder(root: TreeNode): List[List[Int]] =
    val t = convert(root)
    t match
      case None => List()
      case Some(t) =>
        val r = traverse_level(Vector(t), Vector())
        r.map(_.toList).toList
