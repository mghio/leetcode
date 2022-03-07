package cn.mghio.leetcode.tree;

/**
 * Given the root of a binary tree, return its maximum depth.
 *
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node
 * down to the farthest leaf node.
 *
 * @author mghio
 * @since 2022-03-07
 */
public class MaxDepth {

  /**
   * Given the root of a binary tree, return its maximum depth.
   *
   * @param root the tree root node
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
