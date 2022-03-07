package cn.mghio.leetcode.dp;

/**
 * Given a string s, find the longest palindromic subsequence's length in s.
 *
 * @author mghio
 * @since 2022-03-06
 */
public class LongestPalindromeSubseq {

  /**
   * Find the longest palindromic subsequence's length in s.
   *
   * @param s the original string
   * @return the longest palindromic subsequence
   */
  public int longestPalindromeSubseq(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }

    int len = s.length();
    int[][] dp = new int[len][len];
    char[] arr = s.toCharArray();
    for (int i = 0; i < dp.length; i++) {
      dp[i][i] = 1;
    }

    for (int i = len - 1; i >= 0; i--) {
      for (int j = i + 1; j < len; j++) {
        if (arr[i] == arr[j]) {
          dp[i][j] = dp[i + 1][j - 1] + 2;
        } else {
          dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
        }
      }
    }

    return dp[0][len - 1];
  }

  /**
   * Find the longest palindromic subsequence's length in s.
   *
   * @param s the original string
   * @return the longest palindromic subsequence
   */
  public int longestPalindromeSubseqSolution2(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }

    int len = s.length();
    int[] dp = new int[len];
    char[] arr = s.toCharArray();

    for (int i = len - 1; i >= 0; i--) {
      for (int j = i + 1; j < len; j++) {
        if (arr[i] == arr[j]) {
          dp[j] = dp[j - 1] + 2;
        } else {
          dp[j] = Math.max(dp[j], dp[j - 1]);
        }
      }
    }

    return dp[len - 1];
  }

}
