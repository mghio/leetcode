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

}
