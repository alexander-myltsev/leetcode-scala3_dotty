class TreeNode(var _value: Int):
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null

object Solution:
  def isUnival(t: TreeNode, v: Int): Boolean =
    Option(t)
      .map(x => x.value == v && isUnival(x.left, v) && isUnival(x.right, v))
      .getOrElse(true)
  
  def isUnivalTree(root: TreeNode): Boolean =
    isUnival(root, root.value)
