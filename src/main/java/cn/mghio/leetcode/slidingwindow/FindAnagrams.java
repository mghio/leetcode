package cn.mghio.leetcode.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
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
   * @param t the target string
   * @return the result
   */
  public List<Integer> findAnagrams(String s, String t) {
    if (s == null || s.length() == 0 || t == null || t.length() == 0) {
      return List.of();
    }

    Map<Character, Integer> needs = new HashMap<>();
    Map<Character, Integer> window = new HashMap<>();
    for (char c : t.toCharArray()) {
      needs.put(c, needs.getOrDefault(c, 0) + 1);
    }

    int left = 0, right = 0;
    int valid = 0;
    List<Integer> res = new ArrayList<>();

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
          res.add(left);
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

    return res;
  }

}
