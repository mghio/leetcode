package cn.mghio.leetcode.dp;

import java.util.Arrays;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 *
 * The robot can only move either down or right at any point in time. The robot is trying to reach
 * the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 *
 * How many possible unique paths are there?
 *
 * @author mghio
 * @since 2021-11-11
 */
public class UniquePaths {

  /**
   * Return how many possible unique paths are there.
   *
   * @param m the m of grid
   * @param n the n of grid
   * @return the unique paths count
   */
  public int uniquePathsSolution1(int m, int n) {
    int[][] f = new int[m][n];

    for (int i = 0; i < m; i++) {
      f[i][0] = 1;
    }

    for (int j = 0; j < n; j++) {
      f[0][j] = 1;
    }

    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        f[i][j] = f[i - 1][j] + f[i][j - 1];
      }
    }

    return f[m - 1][n - 1];
  }

  /**
   * Return how many possible unique paths are there.
   *
   * @param m the m of grid
   * @param n the n of grid
   * @return the unique paths count
   */
  public int uniquePathsSolution2(int m, int n) {
    int[] cur = new int[n];
    Arrays.fill(cur, 1);

    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        cur[j] += cur[j - 1];
      }
    }
    return cur[n - 1];
  }

}
