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
    return dp(grid, row - 1, col - 1);
  }

  private int dp(int[][] grid, int i, int j) {
    if (i == 0 && j == 0) {
      return grid[0][0];
    }

    if (i < 0 || j < 0) {
      return Integer.MAX_VALUE;
    }

    return Math.min(dp(grid, i - 1, j), dp(grid, i, j - 1)) + grid[i][j];
  }

}
