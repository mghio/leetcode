package java.cn.mghio.leetcode.dp;

/**
 * Given a string containing just the characters '(' and ')', find the length of the longest valid
 * (well-formed) parentheses substring.
 *
 * @author mghio
 * @since 2021-10-31
 */
public class LongestValidParentheses {

  /**
   * Find the length of the longest valid(well-formed) parentheses substring.
   *
   * @param s the string
   * @return the length of the longest valid parentheses substring
   */
  public int longestValidParentheses(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }

    int ans = 0;
    int[] dp = new int[s.length()];
    for (int i = 1; i < s.length(); i++) {
      if (s.charAt(i) == ')') {
        if (s.charAt(i - 1) == '(') {
          // s[i] = '(' && s[i - 1] == ')' then dp[i] = dp[i - 2] + 2
          dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
        } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
          // s[i] = ')' && dp[i - 1] == ')' && s[i - dp[i - 1] - 1] = 'c' then dp[i] = dp[i - 1] + dp[i - dp[i - 1] - 2] + 2
          dp[i] = dp[i - 1] + (i - dp[i - 1] >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
        }
        ans = Math.max(ans, dp[i]);
      }
    }

    return ans;
  }

}
