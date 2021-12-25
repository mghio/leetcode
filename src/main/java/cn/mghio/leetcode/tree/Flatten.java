package cn.mghio.leetcode.tree;

/**
 * Given the root of a binary tree, flatten the tree into a "linked list".
 *
 * @author mghio
 * @since 2021-12-25
 */
public class Flatten {

  /**
   * Given the root of a binary tree, flatten the tree into a "linked list".
   *
   * @param root the root node
   */
  public void flatten(TreeNode root) {
    if (root == null) {
      return;
    }

    flatten(root.left);
    flatten(root.right);

    TreeNode left = root.left;
    TreeNode right = root.right;

    root.left = null;
    root.right = left;

    TreeNode p = root;
    while (p.right != null) {
      p = p.right;
    }
    p.right = right;
  }

}
