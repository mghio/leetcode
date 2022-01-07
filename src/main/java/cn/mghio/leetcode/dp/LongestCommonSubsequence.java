package cn.mghio.leetcode.dp;

import java.util.Arrays;

/**
 * Given two strings text1 and text2, return the length of their longest common subsequence. If
 * there is no common subsequence, return 0.
 *
 * @author mghio
 * @since 2022-01-06
 */
public class LongestCommonSubsequence {

  // 备忘录
  int[][] memo;

  /**
   * Return the length of their longest common subsequence.
   *
   * @param text1 the string
   * @param text2 the other string
   * @return the length of their longest common subsequence
   */
  public int longestCommonSubsequence(String text1, String text2) {
    if ((text1 == null || text1.length() == 0)
        || (text2 == null || text2.length() == 0)) {
      return 0;
    }

    int len1 = text1.length();
    int len2 = text2.length();
    memo = new int[len1][len2];
    for (int[] row : memo) {
      Arrays.fill(row, 1);
    }

    return dp(text1, 0, text2, 0);
  }

  /**
   * Return the length of their longest common subsequence.
   *
   * @param text1 the string
   * @param text2 the other string
   * @return the length of their longest common subsequence
   */
  public int longestCommonSubsequenceSolution2(String text1, String text2) {
    if ((text1 == null || text1.length() == 0)
        || (text2 == null || text2.length() == 0)) {
      return 0;
    }

    int m = text1.length();
    int n = text2.length();
    int[][] dp = new int[m + 1][n + 1];

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1] + 1;
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }

    return dp[m][n];
  }

  private int dp(String text1, int i, String text2, int j) {
    if (i == text1.length() || j == text2.length()) {
      return 0;
    }

    if (memo[i][j] != -1) {
      return memo[i][j];
    }

    char t1 = text1.charAt(i);
    char t2 = text2.charAt(j);

    if (t1 == t2) {
      memo[i][j] = dp(text1, i + 1, text2, j + 1) + 1;
    } else {
      memo[i][j] = Math.max(dp(text1, i + 1, text2, j), dp(text1, i, text2, j + 1));
    }

    return memo[i][j];
  }

}
