package cn.mghio.leetcode.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 * @author mghio
 * @since 2022-02-27
 */
public class LengthOfLongestSubstring {

  public int lengthOfLongestSubstring(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }

    int left = 0;
    int right = 0;
    int res = 0;
    Map<Character, Integer> window = new HashMap<>();
    while (right < s.length()) {
      char c = s.charAt(right);
      right++;
      window.put(c, window.getOrDefault(c, 0) + 1);
      while (window.get(c) > 1) {
        char d = s.charAt(left);
        left++;
        window.put(d, window.get(d) - 1);
      }
      res = Math.max(res, right - left);
    }
    return res;
  }

}
