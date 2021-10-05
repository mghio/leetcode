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

  /*-----------------------------------------------------------------------------------------*/

  // <char, frequency>
  private final Map<Character, Integer> map = new HashMap<>();

  /**
   * Sort given string in decreasing order based on the frequency of the characters.
   *
   * @param src the source string
   * @return the decreasing order based on the frequency of the characters
   */
  public String frequencySortInMaxHeap(String src) {
    if (src == null || src.length() < 2) {
      return src;
    }

    for (char c : src.toCharArray()) {
      map.put(c, map.getOrDefault(c, 0) + 1);
    }
    // build min heap base map keys set
    char[] heapArr = new char[map.size()];
    int index = 0;
    for (char c : map.keySet()) {
      heapArr[index++] = c;
    }

    // heapify
    for (int i = heapArr.length / 2; i >= 0; i--) {
      heapify(heapArr, heapArr.length, i);
    }

    // swap the heap last with first element and heapify
    for (int i = heapArr.length - 1; i >= 0; i--) {
      swap(heapArr, 0, i);
      heapify(heapArr, heapArr.length, i);
    }

    StringBuilder sb = new StringBuilder();
    for (char c : heapArr) {
      int frequency = map.get(c);
      sb.append(String.valueOf(c).repeat(Math.max(0, frequency)));
    }

    return sb.toString();
  }

  private void heapify(char[] a, int n, int i) {
    while (true) {
      int minPos = i;
      int l = 2 * i + 1;
      int r = 2 * i + 2;

      if (l < n && map.get(a[i]) > map.get(a[l])) {
        minPos = l;
      }
      if (r < n && map.get(a[minPos]) > map.get(a[r])) {
        minPos = r;
      }
      if (minPos == i) {
        break;
      }

      swap(a, i, minPos);
      i = minPos;
    }
  }

  private void swap(char[] a, int i, int minPos) {
    char tmp = a[i];
    a[i] = a[minPos];
    a[minPos] = tmp;
  }

}
