package cn.mghio.leetcode.dp;

import java.util.Arrays;

/**
 * Given two strings s1 and s2, return the lowest ASCII sum of deleted characters to make two
 * strings equal.
 *
 * @author mghio
 * @since 2022-02-22
 */
public class MinimumDeleteSum {

  private int[][] memo;

  /**
   * Given two strings s1 and s2, return the lowest ASCII sum of deleted characters to make two
   * strings equal.
   *
   * @param s1 the string s1
   * @param s2 the other string s2
   * @return the lowest ASCII sum of deleted characters to make two strings equal
   */
  public int minimumDeleteSum(String s1, String s2) {
    int m = s1.length();
    int n = s2.length();
    memo = new int[m][n];
    for (int[] ints : memo) {
      Arrays.fill(ints, -1);
    }

    return dp(s1, 0, s2, 0);
  }

  private int dp(String s1, int i, String s2, int j) {
    int res = 0;
    if (i == s1.length()) {
      for (; j < s2.length(); j++) {
        res += s2.charAt(j);
      }
      return res;
    }

    if (j == s2.length()) {
      for (; i < s1.length(); i++) {
        res += s1.charAt(i);
      }
      return res;
    }

    if (memo[i][j] != -1) {
      return memo[i][j];
    }

    char c1 = s1.charAt(i);
    char c2 = s2.charAt(j);
    if (c1 == c2) {
      memo[i][j] = dp(s1, i + 1, s2, j + 1);
    } else {
      memo[i][j] = Math.min(s1.charAt(i) + dp(s1, i + 1, s2, j),
          s2.charAt(j) + dp(s1, i, s2, j + 1));
    }
    return memo[i][j];
  }

}
