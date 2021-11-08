package java.cn.mghio.leetcode.dp;

/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain
 * amount of money stashed, the only constraint stopping you from robbing each of them is that
 * adjacent houses have security systems connected and it will automatically contact the police if
 * two adjacent houses were broken into on the same night.
 *
 * Given an integer array nums representing the amount of money of each house, return the maximum
 * amount of money you can rob tonight without alerting the police.
 *
 * @author mghio
 * @since 2021-11-08
 */
public class Rob {

  /**
   * Return the maximum amount of money you can rob tonight without alerting the police.
   *
   * @param nums the integer array
   * @return the maximum amount of money you can rob tonight without alert the police
   */
  public int rob(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    if (nums.length < 2) {
      return nums[0];
    }

    int n = nums.length;
    int[] dp = new int[n];
    dp[0] = nums[0];
    dp[1] = Math.max(nums[0], nums[1]);
    for (int i = 2; i < n; i++) {
      dp[i] = Math.max(dp[i - 1], dp[i - 2] + dp[i]);
    }
    return dp[n - 1];
  }

}
