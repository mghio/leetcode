package cn.mghio.leetcode.slidingwindow;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
 *
 * In other words, return true if one of s1's permutations is the substring of s2.
 *
 * @author mghio
 * @since 2022-01-14
 */
public class CheckInclusion {

  /**
   * Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false
   * otherwise.
   *
   * @param t the target string
   * @param s the source string
   * @return return true if s2 contains a permutation of s1, or false otherwise
   */
  public boolean checkInclusion(String t, String s) {
    if (t == null || t.length() == 0) {
      return true;
    }

    Map<Character, Integer> needs = new HashMap<>();
    Map<Character, Integer> window = new HashMap<>();
    for (char c : t.toCharArray()) {
      needs.put(c, needs.getOrDefault(c, 0) + 1);
    }

    int left = 0, right = 0;
    int valid = 0;
    while (right < s.length()) {
      char c = s.charAt(right);
      right++;
      if (needs.containsKey(c)) {
        window.put(c, window.getOrDefault(c, 0) + 1);
        if (Objects.equals(needs.get(c), window.get(c))) {
          valid++;
        }
      }

      while (right - left >= t.length()) {
        if (valid == needs.size()) {
          return true;
        }
        char d = s.charAt(left);
        left++;
        if (needs.containsKey(d)) {
          if (Objects.equals(needs.get(d), window.get(d))) {
            valid--;
          }
          window.put(d, window.get(d) - 1);
        }
      }
    }
    return false;
  }

}
