package java.cn.mghio.leetcode.tree;

/**
 * Given a binary tree, determine if it is height-balanced.
 *
 * @author mghio
 * @since 2021-09-30
 */
public class BalanceBinaryTree {

  /**
   * determine given binary tree is balanced.
   *
   * @param root the root node
   * @return true represent balance, else false
   */
  public boolean isBalanced(TreeNode root) {
    if (root == null) {
      return true;
    }

    return isBalanced(root.left) && isBalanced(root.right)
        && Math.abs(deep(root.left) - deep(root.right)) < 2;
  }

  private int deep(TreeNode node) {
    if (node == null) {
      return 0;
    }

    if (node.left == null && node.right == null) {
      return 1;
    }

    return Math.max(deep(node.left), deep(node.right)) + 1;
  }

}
