package cn.mghio.leetcode.dp;

/**
 * Given an input string s and a pattern p, implement regular expression matching with support for
 * '.' and '*' where:
 *
 * '.' Matches any single character. '*' Matches zero or more of the preceding element.
 *
 * The matching should cover the entire input string (not partial).
 *
 * @author mghio
 * @since 2022-02-22
 */
public class IsMatch {

  /**
   * Given an input string s and a pattern p, implement regular expression matching with support for
   * '.' and '*' where:
   *
   * @param s the string
   * @param p the pattern
   * @return the match is true, else false
   */
  public boolean isMatch(String s, String p) {
    return dp(s, 0, p, 0);
  }

  private boolean dp(String s, int i, String p, int j) {
    int m = s.length();
    int n = p.length();
    if (j == n) {
      return i == m;
    }

    if (i == s.length()) {
      if ((n - j) % 2 == 1) {
        return false;
      }
      for (; j + 1 < p.length(); j += 2) {
        if (p.charAt(j + 1) != '*') {
          return false;
        }
      }
      return true;
    }

    if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
      if (j < p.length() - 1 && p.charAt(j + 1) == '*') {
        // Wildcard matches 0 times
        return dp(s, i, p, j + 2)
            // Wildcard matches more times
            || dp(s, i + 1, p, j);
      } else {
        return dp(s, i + 1, p, j + 1);
      }
    } else {
      if (j < p.length() - 1 && p.charAt(j + 1) == '*') {
        // Wildcard matches 0 times
        return dp(s, i, p, j + 2);
      } else {
        return false;
      }
    }
  }

}
