package cn.mghio.leetcode.string;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 * @author mghio
 * @since 2021-04-02
 */
public class LongestPalindrome {

  /**
   * 方法一：暴力解法
   */
  public String longestPalindrome(String s) {
    if (s == null || s.length() < 2) {
      return s;
    }

    int maxLen = 1;
    int begin = 0;
    // s.chatAt(i) 每次都会检查数组下标越界，因此先转换成字符数组，这一步非必须
    char[] charArray = s.toCharArray();

    // 枚举所有长度大于 1 的子串
    for (int i = 0, len = s.length(); i < len - 1; i++) {
      for (int j = i + 1; j < len; j++) {
        if (j - i + 1 > maxLen && validPalindrome(charArray, i, j)) {
          maxLen = j - i + 1;
          begin = i;
        }
      }
    }

    return s.substring(begin, begin + maxLen);
  }

  /**
   * 验证子串是否为回文串
   */
  private boolean validPalindrome(char[] charArray, int left, int right) {
    while (left < right) {
      if (charArray[left++] != charArray[right--]) {
        return false;
      }
    }
    return true;
  }

}
