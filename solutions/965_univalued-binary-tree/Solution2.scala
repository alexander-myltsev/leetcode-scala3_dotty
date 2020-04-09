class TreeNode(var _value: Int):
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null

case class Tree(value: Int, left: Option[Tree], right: Option[Tree]):
  def isLeaf: Boolean = left.isEmpty && right.isEmpty

def (n: TreeNode).convert: Option[Tree] =
  Option(n).map(n => Tree(value = n.value, left = n.left.convert, right = n.right.convert))

def (n: Option[Tree]).convert: TreeNode =
  n.map { n =>
    val tn = new TreeNode(n.value)
    tn.left = convert(n.left)
    tn.right = convert(n.right)
    tn
  }.getOrElse(null)

object Solution:
  def isUnival(t: Option[Tree], v: Int): Boolean =
    t.map { case Tree(x, l, r) => v == x && isUnival(l, v) && isUnival(r, v) }
     .getOrElse(true)

  def isUnivalTree(tn: TreeNode): Boolean =
    tn.convert match
      case None => throw new IllegalArgumentException("")
      case s @ Some(t) => isUnival(s, t.value)
