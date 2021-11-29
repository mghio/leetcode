package cn.mghio.leetcode.string;

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
 * @since 2021-11-29
 */
public class FindAnagrams {

  /**
   * Given two strings s and p, return an array of all the start indices of p's anagrams in s.
   *
   * @param s the s string
   * @param p the p string
   * @return an array of all the start indices of p's anagrams in s
   */
  public List<Integer> findAnagrams(String s, String p) {
    List<Integer> ans = new ArrayList<>();

    int left = 0;
    int right = 0;
    int match = 0;
    Map<Character, Integer> needs = new HashMap<>();
    Map<Character, Integer> window = new HashMap<>();
    char[] sChars = s.toCharArray();
    char[] pChars = p.toCharArray();

    for (char c : pChars) {
      needs.put(c, needs.getOrDefault(c, 0) + 1);
    }

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
        if (right - left == p.length()) {
          ans.add(left);
        }
        char c2 = sChars[left];
        if (needs.containsKey(c2)) {
          if (window.containsKey(c2) && window.get(c2) > 0) {
            window.put(c2, window.get(c2) - 1);
            if (window.get(c2) < needs.get(c2)) {
              match--;
            }
          }
        }
        left++;
      }
    }
    return ans;
  }

}
