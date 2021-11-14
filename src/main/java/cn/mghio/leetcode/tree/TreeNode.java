package cn.mghio.leetcode.tree;

/**
 * Tree Node.
 *
 * @author mghio
 * @since 2021-09-25
 */
public class TreeNode {

  int val;
  TreeNode left;
  TreeNode right;

  public TreeNode() {
  }

  public TreeNode(int val) {
    this.val = val;
  }

  public TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
}
