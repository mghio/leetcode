package cn.mghio.leetcode.dp;

/**
 * Given two strings word1 and word2, return the minimum number of steps required to make word1 and
 * word2 the same.
 *
 * @author mghio
 * @since 2022-02-22
 */
public class Distance {

  /**
   * Given two strings word1 and word2, return the minimum number of steps required to make word1
   * and word2 the same.
   *
   * @param word1 the word
   * @param word2 the other word
   * @return the minimum number of steps required to make word1 and word2 the same
   */
  public int minDistance(String word1, String word2) {
    if (word1 == null || word1.length() == 0) {
      if (word2 == null) {
        return 0;
      }
      return word2.length();
    }

    int commonSubsequenceLen = longestCommonSubsequence(word1, word2);
    return (word1.length() - commonSubsequenceLen) + (word2.length() - commonSubsequenceLen);
  }

  private int longestCommonSubsequence(String word1, String word2) {
    int m = word1.length();
    int n = word2.length();
    // dp[i][j] = word[0 ... i -1][0 ... j - 1]
    int[][] dp = new int[m + 1][n + 1];

    for (int i = 1; i <= m; i++) {
      char c1 = word1.charAt(i - 1);
      for (int j = 1; j <= n; j++) {
        char c2 = word2.charAt(j - 1);
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
