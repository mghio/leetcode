package java.cn.mghio.leetcode.heap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string s, sort it in decreasing order based on the frequency of the characters. The
 * frequency of a character is the number of times it appears in the string.
 *
 * @author mghio
 * @since 2021-10-05
 */
public class FrequencySortDesc {

  /**
   * Sort given string in decreasing order based on the frequency of the characters.
   *
   * @param src the source string
   * @return the decreasing order based on the frequency of the characters
   */
  public String frequencySortInHashMap(String src) {
    // <char, frequency>
    Map<Character, Integer> map = new HashMap<>();
    int length = src.length();
    for (int i = 0; i < length; i++) {
      char c = src.charAt(i);
      int frequency = map.getOrDefault(c, 0) + 1;
      map.put(c, frequency);
    }

    List<Character> list = new ArrayList<>(map.keySet());
    list.sort((c1, c2) -> map.get(c2) - map.get(c1));

    StringBuilder sb = new StringBuilder();
    for (char c : list) {
      int frequency = map.get(c);
      sb.append(String.valueOf(c).repeat(Math.max(0, frequency)));
    }

    return sb.toString();
  }

}
