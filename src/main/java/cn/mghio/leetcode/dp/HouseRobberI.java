package cn.mghio.leetcode.dp;

/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain
 * amount of money stashed, the only constraint stopping you from robbing each of them is that
 * adjacent houses have security systems connected and it will automatically contact the police if
 * two adjacent houses were broken into on the same night.
 *
 * Given an integer array nums representing
 * the amount of money of each house, return the maximum amount of money you can rob tonight without
 * alerting the police.
 *
 * @author mghio
 * @since 2022-03-12
 */
public class HouseRobberI {

  public int rob(int[] nums) {
    return dp(nums, 0);
  }

  private int dp(int[] nums, int start) {
    if (start >= nums.length) {
      return 0;
    }

    return Math.max(dp(nums, start + 1),
        nums[start] + dp(nums, start + 2));
  }

}
