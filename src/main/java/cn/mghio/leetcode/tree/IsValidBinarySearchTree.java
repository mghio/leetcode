package cn.mghio.leetcode.tree;

/**
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 *
 * @author mghio
 * @since 2021-09-30
 */
public class IsValidBinarySearchTree {

  /**
   * determine is valid binary search tree(BST).
   *
   * @param root the root node
   * @return true is valid BST, else false
   */
  public boolean isValidBST(TreeNode root) {
    if (root == null || (root.left == null && root.right == null)) {
      return true;
    }

    return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
  }

  public boolean isValidBST(TreeNode node, long min, long max) {
    if (node == null) {
      return true;
    }

    if (node.val <= min || node.val >= max) {
      return false;
    }

    return isValidBST(node.left, min, node.val)
        && isValidBST(node.right, node.val, max);
  }

}
