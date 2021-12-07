package cn.mghio.leetcode.tree;

/**
 * Given the root of a binary tree, return the maximum path sum of any non-empty path.
 *
 * @author mghio
 * @since 2021-12-07
 */
public class MaxPathSum {

  private int ans = Integer.MIN_VALUE;

  /**
   * Given the root of a binary tree, return the maximum path sum of any non-empty path.
   *
   * @param root the root node
   */
  public int maxPathSum(TreeNode root) {
    if (root == null) {
      return 0;
    }

    int left = Math.max(0, maxPathSum(root.left));
    int right = Math.max(0, maxPathSum(root.right));
    ans = Math.max(ans, left + right + root.val);
    return Math.max(left, right) + root.val;
  }

}
