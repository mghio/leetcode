package cn.mghio.leetcode.dp;

/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain
 * amount of money stashed. All houses at this place are arranged in a circle. That means the first
 * house is the neighbor of the last one. Meanwhile, adjacent houses have a security system
 * connected, and it will automatically contact the police if two adjacent houses were broken into
 * on the same night.
 *
 * Given an integer array nums representing the amount of money of each house, return the maximum
 * amount of money you can rob tonight without alerting the police.
 *
 * @author mghio
 * @since 2021-11-09
 */
public class RobII {

  /**
   * Return the maximum amount of money you can rob tonight without alerting the police.
   *
   * @param nums the array
   * @return the maximum amount of money
   */
  public int rob(int[] nums) {
    if (nums == null || nums.length < 1) {
      return 0;
    }

    if (nums.length < 2) {
      return nums[0];
    }

    if (nums.length == 2) {
      return Math.max(nums[0], nums[1]);
    }

    int n = nums.length;
    // for i in [0, nums.length - 2]
    int robAmount1 = robRange(nums, 0, n - 2);
    // for i in [1, nums.length - 1]
    int robAmount2 = robRange(nums, 1, n - 1);
    return Math.max(robAmount1, robAmount2);
  }

  public int robRange(int[] nums, int start, int end) {
    int first = nums[start];
    int second = Math.max(nums[start], nums[start + 1]);
    for (int i = start + 2; i <= end; i++) {
      int tmp = second;
      second = Math.max(second, first + nums[i]);
      first = tmp;
    }
    return second;
  }

}
