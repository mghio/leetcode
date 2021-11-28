package cn.mghio.leetcode.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Given two strings s and t of lengths m and n respectively, return the minimum window substring of
 * s such that every character in t (including duplicates) is included in the window. If there is no
 * such substring, return the empty string "".
 *
 * @author mghio
 * @since 2021-11-28
 */
public class MinWindow {

  /**
   * return the minimum window substring of s such that every character in t (including duplicates)
   * is included in the window.
   *
   * @param s the source string
   * @param t the target string
   * @return the minimum window substring
   */
  public String minWindow(String s, String t) {
    if (s == null || t == null) {
      return "";
    }

    int start = 0;
    int minLen = Integer.MAX_VALUE;
    int left = 0;
    int right = 0;

    Map<Character, Integer> window = new HashMap<>();
    Map<Character, Integer> needs = new HashMap<>();

    for (char c : t.toCharArray()) {
      needs.put(c, needs.getOrDefault(c, 0) + 1);
    }

    int match = 0;
    char[] sChars = s.toCharArray();
    char[] tChars = t.toCharArray();

    while (right < s.length()) {
      char c1 = sChars[right];
      if (needs.containsKey(c1)) {
        window.put(c1, window.getOrDefault(c1, 0) + 1);
        if (Objects.equals(window.get(c1), needs.get(c1))) {
          match++;
        }
      }
      right++;

      while (match == needs.size()) {
        if (right - left < minLen) {
          start = left;
          minLen = right - left;
        }

        char c2 = tChars[left];
        if (needs.containsKey(c2)) {
          window.put(c2, window.getOrDefault(c2, 0) - 1);
          if (window.get(c2) < needs.get(c2)) {
            match--;
          }
        }
        left++;
      }
    }

    return minLen == Integer.MIN_VALUE ? "" : s.substring(start, minLen);
  }

}
