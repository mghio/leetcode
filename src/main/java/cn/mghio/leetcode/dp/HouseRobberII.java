package cn.mghio.leetcode.dp;

/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain
 * amount of money stashed. All houses at this place are arranged in a circle. That means the first
 * house is the neighbor of the last one. Meanwhile, adjacent houses have a security system
 * connected, and it will automatically contact the police if two adjacent houses were broken into
 * on the same night.
 *
 * Given an integer array nums representing the amount of money of each house,
 * return the maximum amount of money you can rob tonight without alerting the police.
 *
 * @author mghio
 * @since 2022-03-12
 */
public class HouseRobberII {

  public int rob(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    int len = nums.length;
    if (len == 1) {
      return nums[0];
    }

    return Math.max(robRange(nums, 0, len - 2),
        robRange(nums, 1, len - 2));
  }

  private int robRange(int[] nums, int start, int end) {
    int len = nums.length;
    if (start >= len || end >= len) {
      return 0;
    }

    int dpI = 0, dpI1 = 0, dpI2 = 0;
    for (int i = end; i >= start; i--) {
      dpI = Math.max(dpI1, nums[i] + dpI2);
      dpI2 = dpI1;
      dpI1 = dpI;
    }
    return dpI;
  }

}
