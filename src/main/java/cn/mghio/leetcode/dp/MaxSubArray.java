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

    int len = nums.length;
    int[] dp = new int[len];

    dp[0] = nums[0];
    for (int i = 1; i < len; i++) {
      dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
    }

    int res = Integer.MIN_VALUE;
    for (int i = 0; i < len; i++) {
      if (res < dp[i]) {
        res = dp[i];
      }
    }

    return res;
  }

  /**
   * Given an integer array nums, find the contiguous subarray (containing at least one number)
   * which has the largest sum and return its sum.
   *
   * @param nums the source arrays
   * @return the sum
   */
  public int maxSubArraySolution2(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    int pre = 0;
    int res = nums[0];
    for (int num : nums) {
      pre = Math.max(num, pre + num);
      res = Math.max(res, pre);
    }

    return res;
  }

}
