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

    int left = 0;
    int right = 0;
    int valid = 0;
    int start = 0;
    int len = Integer.MAX_VALUE;
    Map<Character, Integer> window = new HashMap<>();
    Map<Character, Integer> need = new HashMap<>();

    char[] tChars = t.toCharArray();
    for (char tChar : tChars) {
      need.put(tChar, need.getOrDefault(tChar, 0) + 1);
    }

    while (right < s.length()) {
      char c = s.charAt(right);
      right++;
      if (need.containsKey(c)) {
        window.put(c, window.getOrDefault(c, 0) + 1);
        if (Objects.equals(window.get(c), need.get(c))) {
          valid++;
        }
      }

      while (valid == need.size()) {
        if (right - left < len) {
          start = left;
          len = right - left;
        }
        char d = s.charAt(left);
        left++;
        if (need.containsKey(d)) {
          if (Objects.equals(window.get(d), need.get(d))) {
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
