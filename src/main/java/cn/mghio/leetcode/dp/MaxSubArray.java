package cn.mghio.leetcode.dp;

/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which
 * has the largest sum and return its sum.
 *
 * @author mghio
 * @since 2022-02-21
 */
public class MaxSubArray {

  /**
   * Given an integer array nums, find the contiguous subarray (containing at least one number)
   * which has the largest sum and return its sum.
   *
   * @param nums the source arrays
   * @return the sum
   */
  public int maxSubArray(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    int n = nums.length;
    int[] dp = new int[n];
    dp[0] = nums[0];

    for (int i = 1; i < n; i++) {
      dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
    }

    int res = Integer.MIN_VALUE;
    for (int i : dp) {
      if (res < i) {
        res = i;
      }
    }

    return res;
  }

}
