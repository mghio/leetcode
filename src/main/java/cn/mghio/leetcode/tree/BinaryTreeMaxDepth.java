package java.cn.mghio.leetcode.tree;

/**
 * Given the root of a binary tree, return its maximum depth.
 *
 * @author mghio
 * @since 2021-09-26
 */
public class BinaryTreeMaxDepth {

  /**
   * Get binary tree maximum depth.
   *
   * @param root the root node
   * @return the maximum depth
   */
  public int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    if (root.left == null && root.right == null) {
      return 1;
    }

    return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
  }

}
