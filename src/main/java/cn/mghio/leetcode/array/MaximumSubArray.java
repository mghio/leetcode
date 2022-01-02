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
      if (sum > 0) {
        sum += num;
      } else {
        sum = num;
      }
      ans = Math.max(sum, ans);
    }

    return ans;
  }

}
