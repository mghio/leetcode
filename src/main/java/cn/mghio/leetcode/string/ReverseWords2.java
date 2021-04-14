package cn.mghio.leetcode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * 反转字符串中的单词 III
 *
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 *
 * 提示：
 * 在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 *
 * @author mghio
 * @since 2021-04-14
 */
public class ReverseWords2 {

  public String reverseWords(String s) {
    if (s == null || s.length() == 0) {
      return s;
    }

    // 方法一：原地解法
    String result = solution1(s);

    // 方法二：使用额外空间
    return solution2(s);
  }

  /**
   * 使用额外的空间
   * 时间复杂度：O(N)，其中 N 为字符串的长度。原字符串中的每个字符都会在 O(1) 的时间内放入新字符串中。
   * 空间复杂度：O(N)。我们开辟了与原字符串等大的空间。
   */
  private String solution2(String s) {
    StringBuilder ret = new StringBuilder();
    int length = s.length();
    int i = 0;
    while (i < length) {
      int start = i;
      while (i < length && s.charAt(i) != ' ') {
        i++;
      }
      for (int j = start; j < i; j++) {
        int wordPerIndex = start + i - 1 - j;
        ret.append(s.charAt(wordPerIndex));
      }
      while (i < length && s.charAt(i) == ' ') {
        i++;
        ret.append(' ');
      }
    }
    return ret.toString();
  }

  /**
   * 方法一：原地解法
   *
   * 时间复杂度：O(N)，其中 N 为字符串的长度。原字符串中的每个字符都会在 O(1) 的时间内放入新字符串中。
   * 空间复杂度：O(N)。我们开辟了与原字符串等大的空间。
   */
  private String solution1(String s) {
    String[] strings = s.split(" ");
    List<String> resultString = new ArrayList<>();
    for (String string : strings) {
      char[] chars = string.toCharArray();
      for (int i = 0, length = chars.length; i < length / 2; i++) {
        doSwap(chars, i, length);
      }
      resultString.add(new String(chars));
    }
    return String.join(" ", resultString);
  }

  private void doSwap(char[] chars, int i, int length) {
    char temp = chars[i];
    chars[i] = chars[length - i - 1];
    chars[length - i - 1] = temp;
  }

}
