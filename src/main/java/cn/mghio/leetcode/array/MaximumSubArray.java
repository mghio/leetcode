package cn.mghio.leetcode.array;

/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which
 * has the largest sum and return its sum.
 *
 * A subarray is a contiguous part of an array.
 *
 * @author mghio
 * @since 2022-01-02
 */
public class MaximumSubArray {

  /**
   * Find the contiguous subarray which has the largest sum and return its num.
   *
   * @param nums the num array
   * @return the largest sum
   */
  public int maxSubArray(int[] nums) {
    int ans = nums[0];
    int sum = 0;

    for (int num : nums) {
      sum = Math.max(num, sum + num);
      ans = Math.max(sum, ans);
    }

    return ans;
  }

  /**
   * Find the contiguous subarray which has the largest sum and return its num.
   *
   * @param nums the num array
   * @return the largest sum
   */
  public int maxSubArraySolution2(int[] nums) {
    int len = nums.length;
    // dp[i] means: the maximum sum of consecutive sub-arrays ending in nums[i]
    int[] dp = new int[len];
    dp[0] = nums[0];

    for (int i = 1; i < len; i++) {
      if (dp[i - 1] > 0) {
        dp[i] = dp[i - 1] + nums[i];
      } else {
        dp[i] = nums[i];
      }
    }

    int ans = dp[0];
    for (int i = 1; i < len; i++) {
      if (ans < dp[i]) {
        ans = dp[i];
      }
    }

    return ans;
  }

}
