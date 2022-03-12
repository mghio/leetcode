package cn.mghio.leetcode.dp;

import java.util.Arrays;

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

  private int[] memo;

  public int rob(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    memo = new int[nums.length];
    Arrays.fill(memo, -1);
    return dp(nums, 0);
  }

  private int dp(int[] nums, int start) {
    if (start >= nums.length) {
      return 0;
    }

    if (memo[start] != -1) {
      return memo[start];
    }

    int res = Math.max(dp(nums, start + 1),
        nums[start] + dp(nums, start + 2));
    memo[start] = res;
    return res;
  }

  public int robSolution2(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    int len = nums.length;
    int[] dp = new int[len + 2];
    for (int i = len - 1; i >= 0; i--) {
      dp[i] = Math.max(dp[i + 1], nums[i] + dp[i + 2]);
    }

    return dp[0];
  }

}
