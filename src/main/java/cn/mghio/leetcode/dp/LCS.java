package cn.mghio.leetcode.dp;

import java.util.Arrays;

/**
 * Given two strings text1 and text2, return the length of their longest common subsequence. If
 * there is no common subsequence, return 0.
 *
 * @author mghio
 * @since 2022-02-22
 */
public class LCS {

  private int[][] memo;

  /**
   * Given two strings text1 and text2, return the length of their longest common subsequence. If
   * there is no common subsequence, return 0.
   *
   * @param text1 the string
   * @param text2 the other string
   * @return the common subsequence length
   */
  public int longestCommonSubsequence(String text1, String text2) {
    if (text1 == null || text1.length() == 0 || text2 == null || text2.length() == 0) {
      return 0;
    }

    memo = new int[text1.length()][text2.length()];
    for (int[] row : memo) {
      Arrays.fill(row, -1);
    }

    return dp(text1, 0, text2, 0);
  }

  private int dp(String text1, int i, String text2, int j) {
    if (i == text1.length() || j == text2.length()) {
      return 0;
    }

    if (memo[i][j] != -1) {
      return memo[i][j];
    }

    if (text1.charAt(i) == text2.charAt(j)) {
      memo[i][j] = dp(text1, i + 1, text2, j + 1);
    } else {
      memo[i][j] = Math.max(dp(text1, i + 1, text2, j), dp(text1, i, text2, j + 1));
    }

    return memo[i][j];
  }

  /**
   * Given two strings text1 and text2, return the length of their longest common subsequence. If
   * there is no common subsequence, return 0.
   *
   * @param text1 the string
   * @param text2 the other string
   * @return the common subsequence length
   */
  public int longestCommonSubsequenceSolution2(String text1, String text2) {
    if (text1 == null || text1.length() == 0 || text2 == null || text2.length() == 0) {
      return 0;
    }

    int m = text1.length();
    int n = text2.length();
    int[][] dp = new int[m + 1][n + 1];

    for (int i = 1; i <= m; i++) {
      char c1 = text1.charAt(i - 1);
      for (int j = 1; j <= n; j++) {
        char c2 = text2.charAt(j - 1);
        if (c1 == c2) {
          dp[i][j] = dp[i - 1][j - 1] + 1;
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }

    return dp[m][n];
  }

}
