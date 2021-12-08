package cn.mghio.leetcode.tree;

/**
 * Given a binary tree root, return the maximum sum of all keys of any sub-tree which is also a
 * Binary Search Tree (BST).
 *
 * @author mghio
 * @since 2021-12-08
 */
public class MaxSumBST {

  private int maxSum;

  /**
   * Return the maximum sum of all keys of any sub-tree which is also a BST.
   *
   * @param root the root node
   * @return the maximum sum of all keys
   */
  public int maxSumBST(TreeNode root) {
    return traverse(root)[3];
  }

  private int[] traverse(TreeNode root) {
    if (root == null) {
      return new int[]{
          1, Integer.MAX_VALUE, Integer.MIN_VALUE, 0
      };
    }

    int[] left = traverse(root.left);
    int[] right = traverse(root.right);

    // res = int[]{ isBST, min, max, sum}
    int[] res = new int[4];
    if (left[0] == 1
        && right[0] == 1
        && root.val > left[2] &&
        root.val < left[1]) {
      res[0] = 1;
      res[1] = root.val;
      res[2] = Math.max(right[2], root.val);
      res[3] = left[3] + right[3] + root.val;

      maxSum = Math.max(maxSum, res[3]);
    } else {
      res[0] = 0;
    }

    return res;
  }

}
