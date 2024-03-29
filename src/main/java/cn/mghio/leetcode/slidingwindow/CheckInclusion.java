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

    int left = 0;
    int right = 0;
    int valid = 0;
    Map<Character, Integer> need = new HashMap<>();
    Map<Character, Integer> window = new HashMap<>();
    for (char c : s.toCharArray()) {
      need.putIfAbsent(c, need.getOrDefault(c, 0) + 1);
    }

    while (right < s.length()) {
      char c = s.charAt(right);
      right++;
      if (need.containsKey(c)) {
        window.put(c, window.getOrDefault(c, 0) + 1);
        if (Objects.equals(need.get(c), window.get(c))) {
          valid++;
        }
      }

      while (right - left >= t.length()) {
        if (valid == need.size()) {
          return true;
        }
        char d = s.charAt(left);
        left++;
        if (need.containsKey(d)) {
          if (Objects.equals(need.get(d), window.get(d))) {
            valid--;
          }
          window.put(d, window.get(d) - 1);
        }
      }
    }

    return false;
  }

}
