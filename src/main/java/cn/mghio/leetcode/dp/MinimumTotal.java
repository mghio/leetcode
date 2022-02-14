package cn.mghio.leetcode.dp;

import java.util.List;

/**
 * Given a triangle array, return the minimum path sum from top to bottom.
 *
 * For each step, you may move to an adjacent number of the row below. More formally, if you are on
 * index i on the current row, you may move to either index i or index i + 1 on the next row.
 *
 * @author mghio
 * @since 2022-02-12
 */
public class MinimumTotal {

  /**
   * Given a triangle array, return the minimum path sum from top to bottom.
   *
   * @param triangle the triangle
   * @return the minimum total
   */
  public int minimumTotal(List<List<Integer>> triangle) {
    if (triangle == null || triangle.size() == 0) {
      return 0;
    }

    int m = triangle.size();
    int[][] dp = new int[m][];
    List<Integer> lastRow = triangle.get(m - 1);
    for (int i = 0; i < lastRow.size(); i++) {
      dp[m - 1][i] = lastRow.get(i);
    }

    for (int i = triangle.size() - 2; i >= 0; i--) {
      for (int j = 0; j < triangle.get(i).size(); j++) {
        dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
      }
    }

    return dp[0][0];
  }

  /**
   * Given a triangle array, return the minimum path sum from top to bottom.
   *
   * @param triangle the triangle
   * @return the minimum total
   */
  public int minimumTotalSolution2(List<List<Integer>> triangle) {
    if (triangle == null || triangle.size() == 0) {
      return 0;
    }

    int m = triangle.size();
    int[] mini = new int[m];
    for (int i = 0; i < triangle.get(m - 1).size(); i++) {
      mini[i] = triangle.get(m - 1).get(i);
    }

    for (int i = triangle.size() - 2; i >= 0; i--) {
      for (int j = 0; j < triangle.get(i).size(); j++) {
        mini[j] = triangle.get(i).get(j) + Math.min(mini[j], mini[j + 1]);
      }
    }

    return mini[0];
  }

  private int[][] memo;

  /**
   * Given a triangle array, return the minimum path sum from top to bottom.
   *
   * @param triangle the triangle
   * @return the minimum total
   */
  public int minimumTotalSolution3(List<List<Integer>> triangle) {
    if (triangle == null || triangle.size() == 0) {
      return 0;
    }

    memo = new int[triangle.size()][triangle.size()];
    return dfs(triangle, 0, 0);
  }

  private int dfs(List<List<Integer>> triangle, int i, int j) {
    if (i == triangle.size()) {
      return 0;
    }

    if (memo[i][j] != 0) {
      return memo[i][j];
    }

    memo[i][j] =
        Math.min(dfs(triangle, i + 1, j), dfs(triangle, i + 1, j + 1)) + triangle.get(i).get(j);
    return memo[i][j];
  }

  /**
   * Given a triangle array, return the minimum path sum from top to bottom.
   *
   * @param triangle the triangle
   * @return the minimum total
   */
  public int minimumTotalSolution4(List<List<Integer>> triangle) {
    if (triangle == null || triangle.size() == 0) {
      return 0;
    }

    int n = triangle.size();
    int[] dp = new int[n + 1];
    for (int i = n - 1; i >= 0; i--) {
      for (int j = 0; j <= i; j++) {
        dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
      }
    }

    return dp[0];
  }

}
