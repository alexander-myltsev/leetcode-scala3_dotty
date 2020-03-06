class TreeNode(_value: Int)
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null

object Solution
  def rangeSumBST(root: TreeNode, l: Int, r: Int): Int =
    if (root == null)
      0
    else
      val r1 =
        if (l <= root.value && root.value <= r) root.value
        else 0

      val r2 =
        if (root.value > l) rangeSumBST(root.left, l, r)
        else 0

      val r3 =
        if (root.value < r) rangeSumBST(root.right, l, r)
        else 0

      r1 + r2 + r3
