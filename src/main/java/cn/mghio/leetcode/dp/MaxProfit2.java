package cn.mghio.leetcode.dp;

/**
 * You are given an integer array prices where prices[i] is the price of a given stock on the ith
 * day.
 *
 * On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of
 * the stock at any time. However, you can buy it then immediately sell it on the same day.
 *
 * Find and return the maximum profit you can achieve.
 *
 * @author mghio
 * @since 2021-11-07
 */
public class MaxProfit2 {

  /**
   * Find and return the maximum profit you can achieve.
   *
   * @param prices the prices array
   * @return the maximum profit
   */
  public int maxProfitSolution1(int[] prices) {
    if (prices == null || prices.length < 2) {
      return 0;
    }

    int n = prices.length;
    int[][] dp = new int[n][2];
    dp[0][0] = 0;
    dp[0][1] = -prices[0];

    for (int i = 1; i < n; i++) {
      dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
      dp[i][1] = Math.max(dp[i - 1][0] - prices[i], dp[i - 1][1]);
    }

    return dp[n - 1][0];
  }

  /**
   * Find and return the maximum profit you can achieve.
   *
   * @param prices the prices array
   * @return the maximum profit
   */
  public int maxProfitSolution2(int[] prices) {
    if (prices == null || prices.length < 2) {
      return 0;
    }

    int n = prices.length;
    int dp0 = 0;
    int dp1 = -prices[0];

    for (int i = 1; i < n; i++) {
      int curPrice = prices[i];
      dp0 = Math.max(dp0, dp1 + curPrice);
      dp1 = Math.max(dp0 - curPrice, dp1);
    }

    return dp0;
  }

}
