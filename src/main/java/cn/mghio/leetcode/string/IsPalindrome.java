package cn.mghio.leetcode.string;

/**
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and
 * removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric
 * characters include letters and numbers.
 *
 * Given a string s, return true if it is a palindrome, or false otherwise.
 *
 * @author mghio
 * @since 2021-11-24
 */
public class IsPalindrome {

  /**
   * Given a string s, return true if it is a palindrome, or false otherwise.
   *
   * @param s the string
   * @return true if it is a palindrome, else false
   */
  public boolean isPalindromeSolution1(String s) {
    if (s == null) {
      return true;
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if (Character.isLetterOrDigit(ch)) {
        sb.append(Character.toLowerCase(ch));
      }
    }
    StringBuilder sbRev = new StringBuilder(sb).reverse();
    return sb.toString().equals(sbRev.toString());
  }

}
