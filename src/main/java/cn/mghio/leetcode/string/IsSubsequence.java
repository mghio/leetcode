package cn.mghio.leetcode.string;

/**
 * Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
 *
 * @author mghio
 * @since 2021-11-30
 */
public class IsSubsequence {

  /**
   * given two strings s and t, return true if s is a subsequence of t, or false otherwise.
   *
   * @return return true if s is a subsequence of t, or false otherwise
   */
  public boolean isSubsequenceSolution1(String s, String t) {
    int i = 0;
    int j = 0;
    while (i < s.length() && j < t.length()) {
      if (s.charAt(i) == t.charAt(j)) {
        i++;
      }
      j++;
    }
    return i == s.length();
  }

}
