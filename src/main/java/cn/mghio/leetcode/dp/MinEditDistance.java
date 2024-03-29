package cn.mghio.leetcode.dp;

import java.util.Arrays;

/**
 * Given two strings word1 and word2, return the minimum number of operations required to convert
 * word1 to word2.
 *
 * You have the following three operations permitted on a word:
 *
 * Insert a character
 * Delete a character
 * Replace a character
 *
 * @author mghio
 * @since 2022-01-09
 */
public class MinEditDistance {

  private int[][] memo;

  /**
   * Given two strings word1 and word2, return the minimum number of operations required to convert
   * word1 to word2.
   *
   * @param word1 the word
   * @param word2 the other word
   * @return the minimum distance
   */
  public int minEditDist(String word1, String word2) {
    int m = word1.length();
    int n = word2.length();
    memo = new int[m][n];
    for (int[] ints : memo) {
      Arrays.fill(ints, -1);
    }

    int[][] dp = new int[m + 1][n + 1];
    for (int i = 1; i <= m; i++) {
      dp[i][0] = i;
    }
    for (int j = 1; j <= n; j++) {
      dp[0][j] = j;
    }

    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        if (memo[i][j] != -1) {
          dp[i][j] = memo[i][j];
          continue;
        }

        if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1];
        } else {
          dp[i][j] = getMin(dp, i, j);
        }
      }
    }

    return dp[m][n];
  }

  private int getMin(int[][] dp, int i, int j) {
    return Math.min(dp[i - 1][j] + 1, Math.min(dp[i][j - 1] + 1, dp[i - 1][j - 1] + 1));
  }

  /**
   * Given two strings word1 and word2, return the minimum number of operations required to convert
   * word1 to word2.
   *
   * @param word1 the word
   * @param word2 the other word
   * @return the minimum distance
   */
  public int minEditDistSolution2(String word1, String word2) {
    int m = word1.length();
    int n = word2.length();
    if (m == 0 || n == 0) {
      return m + n;
    }

    int[][] dp = new int[m + 1][n + 1];

    for (int i = 0; i < m + 1; i++) {
      dp[i][0] = i;
    }
    for (int j = 0; j < n + 1; j++) {
      dp[0][j] = j;
    }

    for (int i = 1; i < m + 1; i++) {
      for (int j = 1; j < n + 1; j++) {
        int left = dp[i - 1][j] + 1;
        int down = dp[i][j - 1] + 1;
        int leftDown = dp[i - 1][j - 1] + 1;
        char c1 = word1.charAt(i - 1);
        char c2 = word2.charAt(j - 1);
        if (c1 == c2) {
          leftDown -= 1;
        }
        dp[i][j] = Math.min(left, Math.min(down, leftDown));
      }
    }

    return dp[m][n];
  }

}
