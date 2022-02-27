package cn.mghio.leetcode.slidingwindow;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may
 * return the answer in any order.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 *
 * @author mghio
 * @since 2022-01-15
 */
public class FindAnagrams {

  /**
   * Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may
   * return the answer in any order.
   *
   * @param s the source string
   * @param p the target string
   * @return the result
   */
  public List<Integer> findAnagrams(String s, String p) {
    if (s == null || s.length() == 0 || p == null || p.length() == 0) {
      return List.of();
    }

    int left = 0;
    int right = 0;
    int valid = 0;
    List<Integer> res = new LinkedList<>();
    Map<Character, Integer> window = new HashMap<>();
    Map<Character, Integer> need = new HashMap<>();
    for (char c : p.toCharArray()) {
      need.put(c, need.getOrDefault(c, 0 ) + 1);
    }

    while (right < s.length()) {
      char c = s.charAt(right);
      right++;
      if (need.containsKey(c)) {
        window.put(c, window.getOrDefault(c, 0 ) + 1);
        if (Objects.equals(window.get(c), need.get(c))) {
          valid++;
        }
      }

      while (right - left >= p.length()) {
        if (valid == need.size()) {
          res.add(left);
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

    return res;
  }

}
