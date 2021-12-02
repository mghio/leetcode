package cn.mghio.leetcode.string;

import java.util.Arrays;

/**
 * Given a string s, find the longest palindromic subsequence's length in s.
 *
 * A subsequence is a sequence that can be derived from another sequence by deleting some or no
 * elements without changing the order of the remaining elements.
 *
 * @author mghio
 * @since 2021-12-02
 */
public class LongestPalindromeSubseq {

  /**
   * given a string s, find the longest palindromic subsequence's length in s.
   *
   * @param s the string
   * @return the longest palindromic subsequence's length in s
   */
  public int longestPalindromeSubseq(String s) {
    int n = s.length();
    int[][] dp = new int[n][n];
    for (int[] ints : dp) {
      Arrays.fill(ints, 0);
    }

    for (int i = 0; i < n; i++) {
      dp[i][i] = 1;
    }

    for (int i = n - 1; i >= 0; i--) {
      for (int j = i + 1; j < n; j++) {
        if (s.charAt(i) == s.charAt(j)) {
          dp[i][j] = dp[i + 1][j - 1] + 2;
        } else {
          dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
        }
      }
    }

    return dp[0][n - 1];
  }

}
