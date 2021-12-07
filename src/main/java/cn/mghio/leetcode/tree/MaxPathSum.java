package cn.mghio.leetcode.tree;

/**
 * Given the root of a binary tree, return the maximum path sum of any non-empty path.
 *
 * @author mghio
 * @since 2021-12-07
 */
public class MaxPathSum {

  private int maxSum = Integer.MIN_VALUE;

  /**
   * Given the root of a binary tree, return the maximum path sum of any non-empty path.
   *
   * @param root the root node
   */
  public int maxPathSum(TreeNode root) {
    maxGain(root);
    return maxSum;
  }

  private int maxGain(TreeNode node) {
    if (node == null) {
      return 0;
    }

    int leftGain = Math.max(maxGain(node.left), 0);
    int rightGain = Math.max(maxGain(node.right), 0);
    maxSum = Math.max(maxSum, node.val + leftGain + rightGain);
    return node.val + Math.max(leftGain, rightGain);
  }

}
