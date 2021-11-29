package cn.mghio.leetcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 * @author mghio
 * @since 2021-11-29
 */
public class LengthOfLongestSubstring {

  /**
   * Given a string s, find the length of the longest substring without repeating characters.
   *
   * @param s the source string
   * @return the length of the longest substring without repeating characters
   */
  public int lengthOfLongestSubstring(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }

    int left = 0;
    int right = 0;
    int res = 0;
    int len = s.length();
    char[] sChars = s.toCharArray();
    Map<Character, Integer> window = new HashMap<>();

    while (right < len) {
      char c1 = sChars[right];
      window.put(c1, window.getOrDefault(c1, 0) + 1);
      right++;
      while (window.get(c1) > 1) {
        char c2 = sChars[left];
        if (window.containsKey(c2) && window.get(c2) > 0) {
          window.put(c2, window.get(c2) - 1);
        }
        left++;
      }
      res = Math.max(res, right - left);
    }

    return res;
  }

}
