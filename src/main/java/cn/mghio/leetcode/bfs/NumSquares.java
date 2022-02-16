package cn.mghio.leetcode.bfs;

/**
 * Given an integer n, return the least number of perfect square numbers that sum to n.
 *
 * @author mghio
 * @since 2022-02-16
 */
public class NumSquares {

  /**
   * Given an integer n, return the least number of perfect square numbers that sum to n.
   *
   * @param n the number
   * @return the perfect square number
   */
  public int numSquares(int n) {
    int[] dp = new int[n + 1];

    for (int i = 1; i <= n; i++) {
      int min = Integer.MAX_VALUE;
      for (int j = 1; j * j <= i; j++) {
        min = Math.min(dp[i - j * j], min);
      }
      dp[i] = min + 1;
    }

    return dp[n];
  }

}
