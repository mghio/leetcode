package cn.mghio.leetcode.dp;

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

  private int[][] memo;

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

    int row = grid.length;
    int col = grid[0].length;
    memo = new int[row][col];
    return dp(grid, row - 1, col - 1);
  }

  private int dp(int[][] grid, int i, int j) {
    if (i == 0 && j == 0) {
      return grid[0][0];
    }

    if (i < 0 || j < 0) {
      return Integer.MAX_VALUE;
    }

    if (memo[i][j] != 0) {
      return memo[i][j];
    }

    memo[i][j] = Math.min(dp(grid, i - 1, j), dp(grid, i, j - 1)) + grid[i][j];
    return memo[i][j];
  }


  /**
   * Find minimizes the sum of all numbers along its path.
   *
   * @param grid the paths array
   * @return the min path
   */
  public int minPathSumSolution2(int[][] grid) {
    if (grid == null || grid.length == 0 || grid[0].length == 0) {
      return 0;
    }

    int row = grid.length;
    int col = grid[0].length;
    int[][] dp = new int[row][col];
    dp[0][0] = grid[0][0];

    for (int i = 1; i < row; i++) {
      dp[i][0] = dp[i - 1][0] + grid[i][0];
    }
    for (int j = 1; j < col; j++) {
      dp[0][j] = dp[0][j - 1] + grid[0][j];
    }
    for (int i = 1; i < row; i++) {
      for (int j = 1; j < col; j++) {
        dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
      }
    }
    return dp[row - 1][col - 1];
  }

}
