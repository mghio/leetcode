package cn.mghio.leetcode.slidingwindow;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Given two strings s and t of lengths m and n respectively, return the minimum window substring of
 * s such that every character in t (including duplicates) is included in the window. If there is no
 * such substring, return the empty string "".
 *
 * @author mghio
 * @since 2022-01-13
 */
public class MinWindow {

  /**
   * Given two strings s and t of lengths m and n respectively, return the minimum window substring of
   * s such that every character in t (including duplicates) is included in the window.
   *
   * @param s the source string
   * @param t the target string
   * @return the minimum window substring
   */
  public String minWindow(String s, String t) {
    if (s == null || t == null || s.length() == 0 || t.length() == 0) {
      return "";
    }

    Map<Character, Integer> needs = new HashMap<>();
    Map<Character, Integer> window = new HashMap<>();
    int left = 0;
    int right = 0;
    // the number of characters in the window that meet the need condition
    int valid = 0;

    for (char c : t.toCharArray()) {
      needs.put(c, needs.getOrDefault(c, 0) + 1);
    }

    // start index
    int start = 0;
    // length
    int len = Integer.MAX_VALUE;
    while (right < s.length()) {
      char c = s.charAt(right);
      right++;
      if (needs.containsKey(c)) {
        window.put(c, window.getOrDefault(c, 0) + 1);
        if (Objects.equals(window.get(c), needs.get(c))) {
          valid++;
        }
      }

      while (valid == needs.size()) {
        if (right - left < len) {
          start = left;
          len = right - left;
        }

        char d = s.charAt(left);
        left++;
        if (needs.containsKey(d)) {
          if (Objects.equals(window.get(d), needs.get(d))) {
            valid--;
          }
          window.put(d, window.get(d) - 1);
        }
      }
    }

    return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
  }

  /**
   * Given two strings s and t of lengths m and n respectively, return the minimum window substring of
   * s such that every character in t (including duplicates) is included in the window.
   *
   * @param s the source string
   * @param t the target string
   * @return the minimum window substring
   */
  public String minWindowSolution2(String s, String t) {
    if (s == null || t == null || s.length() == 0 || t.length() == 0) {
      return "";
    }

    int[] needs = new int[128];
    for (char c : t.toCharArray()) {
      needs[c]++;
    }

    int distance = t.length();
    int left = 0;
    int right = 0;
    int start = 0;
    int len = Integer.MAX_VALUE;
    while (right < s.length()) {
      char c = s.charAt(right);
      if (needs[c] > 0) {
        distance--;
      }
      needs[c]--;
      right++;

      while (distance == 0) {
        char d = s.charAt(left);
        if (right - left < len) {
          len = right - left;
          start = left;
        }
        needs[d]++;
        if (needs[d] > 0) {
          distance++;
        }
        left++;
      }
    }

    return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
  }

}
