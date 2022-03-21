package cn.mghio.leetcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Longest Substring Without Repeating Characters.
 *
 * @author mghio
 * @since 2022-03-21
 */
public class lengthOfLongestSubstring2 {

  public int lengthOfLongestSubstring(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }

    int left = 0, right = 0, ret = 0;
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
      ret = Math.max(ret, right - left);
    }
    return ret;
  }

}
