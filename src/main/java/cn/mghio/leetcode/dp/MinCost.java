package cn.mghio.leetcode.dp;

/**
 * Minimum Time to Make Rope Colorful.
 *
 * @author mghio
 * @since 2022-03-16
 */
public class MinCost {

  public int minCost(String colors, int[] neededTime) {
    int len = colors.length();
    int[] dp = new int[len];
    dp[0] = 0;

    for (int i = 1; i < len; i++) {
      if (colors.charAt(i) == colors.charAt(i - 1)) {
        dp[i] = Math.min(neededTime[i], neededTime[i - 1]) + dp[i - 1];
        neededTime[i] = Math.max(neededTime[i - 1], neededTime[i]);
      } else {
        dp[i] = dp[i - 1];
      }
    }

    return dp[len - 1];
  }

}
