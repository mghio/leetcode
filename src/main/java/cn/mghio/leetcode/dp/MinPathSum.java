package java.cn.mghio.leetcode.dp;

/**
 * Given an m x n grid filled with non-negative numbers, find a path from top left to bottom right,
 * which minimizes the sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 *
 * @author mghio
 * @since 2021-10-09
 */
public class MinPathSum {

  /**
   * Find minimizes the sum of all numbers along its path.
   *
   * @param grid the paths array
   * @return the min path
   */
  public int minPathSum(int[][] grid) {
    if (grid == null || grid.length == 0 || grid[0].length == 0) {
      return 0;
    }

    int rowLen = grid.length;
    int colLen = grid[0].length;

    int[][] dp = new int[rowLen][colLen];
    int sum = 0;
    // init first row data
    for (int i = 0; i < colLen; i++) {
      sum += grid[0][i];
      dp[0][i] = sum;
    }
    sum = 0;
    // init first column data
    for (int i = 0; i < rowLen; i++) {
      sum += grid[i][0];
      dp[i][0] = sum;
    }

    for (int i = 1; i < rowLen; i++) {
      for (int j = 1; j < colLen; j++) {
        dp[i][j] = grid[i][j] + Math.min(dp[i][j - 1], dp[i - 1][j]);
      }
    }
    return dp[rowLen - 1][colLen - 1];
  }

}
