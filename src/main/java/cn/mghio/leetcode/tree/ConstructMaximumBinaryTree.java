package cn.mghio.leetcode.tree;

/**
 * You are given an integer array nums with no duplicates.
 * A maximum binary tree can be built recursively from nums using the following algorithm:
 *
 * Create a root node whose value is the maximum value in nums.
 * Recursively build the left subtree on the subarray prefix to the left of the maximum value.
 * Recursively build the right subtree on the subarray suffix to the right of the maximum value.
 * Return the maximum binary tree built from nums
 *
 * @author mghio
 * @since 2021-12-26
 */
public class ConstructMaximumBinaryTree {

  /**
   * Return the maximum binary tree built from nums.
   *
   * @param nums the nums array
   * @return the maximum binary tree built from nums
   */
  public TreeNode constructMaximumBinaryTree(int[] nums) {
    return buildTree(nums, 0, nums.length - 1);
  }

  private TreeNode buildTree(int[] nums, int l, int h) {
    if (h < l) {
      return null;
    }

    int index = findMaxValIndex(nums, l, h);

    TreeNode root = new TreeNode(nums[index]);
    root.left = buildTree(nums, l, index - 1);
    root.right = buildTree(nums, index + 1, h);

    return root;
  }

  private int findMaxValIndex(int[] nums, int l, int h) {
    int index = -1;
    int maxVal = Integer.MIN_VALUE;
    for (int i = l; i <= h; i++) {
      if (maxVal < nums[i]) {
        maxVal = nums[i];
        index = i;
      }
    }
    return index;
  }

}
