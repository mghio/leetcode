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
