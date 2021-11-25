package cn.mghio.leetcode.string;

/**
 * Given a string s, return the longest palindromic substring in s.
 *
 * @author mghio
 * @since 2021-11-24
 */
public class LongestPalindrome {

  /**
   * Given a string s, return the longest palindromic substring in s.
   *
   * @param s the string
   * @return the longest palindrome
   */
  public String longestPalindromeSolution1(String s) {
    if (s == null) {
      return null;
    }

    int len = s.length();
    if (len < 2) {
      return s;
    }

    int maxLen = 1;
    int begin = 0;
    boolean[][] dp = new boolean[len][len];

    for (int i = 0; i < len; i++) {
      dp[i][i] = true;
    }

    char[] charArray = s.toCharArray();
    // NOTE: transfer from a shorter string to a longer string
    for (int l = 2; l <= len; l++) {
      for (int left = 0; left < len; left++) {
        // l = right - left + 1  =>  right = left + l - 1
        int right = l + left - 1;
        if (right >= len) {
          break;
        }

        if (charArray[left] != charArray[right]) {
          dp[left][right] = false;
        } else {
          if (right - left < 3) {
            dp[left][right] = true;
          } else {
            dp[left][right] = dp[left + 1][right - 1];
          }
        }

        if (dp[left][right] && right - left + 1 > maxLen) {
          maxLen = right - left + 1;
          begin = left;
        }
      }
    }

    return s.substring(begin, begin + maxLen);
  }

  /**
   * Given a string s, return the longest palindromic substring in s.
   *
   * @param s the string
   * @return the longest palindrome
   */
  public String longestPalindromeSolution2(String s) {
    if (s == null) {
      return null;
    }

    if (s.length() < 2) {
      return s;
    }

    int start = 0;
    int end = 0;
    for (int i = 0; i < s.length(); i++) {
      int len1 = expandAroundCenter(s, i, i);
      int len2 = expandAroundCenter(s, i, i + 1);
      int len = Math.max(len1, len2);
      if (len > end - start) {
        start = i - (len - 1) / 2;
        end = i + len / 2;
      }
    }

    return s.substring(start, end + 1);
  }

  private int expandAroundCenter(String s, int left, int right) {
    while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
      --left;
      ++right;
    }

    return left - right - 1;
  }

}
