package cn.mghio.leetcode.string;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 *
 * 说明：
 * 无空格字符构成一个单词 。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *
 * @author mghio
 * @since 2021-04-04
 */
public class ReverseWords {

  public String reverseWords(String s) {
    // 特殊边界处理
    if (s == null) {
      return null;
    }
    if (s.trim().length() < 1) {
      return s;
    }

    // 方法一：使用语言特性
//    String result = getReverseWordWithLanguageFeature1(s);
    String result = getReverseWordWithLanguageFeature2(s);

    return result;
  }

  private String getReverseWordWithLanguageFeature2(String s) {
    List<String> wordList = Arrays.asList(s.trim().split("\\s+"));
    Collections.reverse(wordList);
    return String.join(" ", wordList);
  }

  /**
   * 方法一：使用语言特性
   *
   * 时间复杂度：O(N)，其中 N 为输入字符串的长度。
   * 空间复杂度：O(N)，用来存储字符串分割之后的结果。
   */
  private String getReverseWordWithLanguageFeature1(String s) {
    String[] strArray = s.trim().split("\\s+");
    for (int i = 0, len = strArray.length; i < len / 2; i++) {
      String temp = strArray[i];
      strArray[i] = strArray[len - i - 1];
      strArray[len - i - 1] = temp;
    }

    String result = String.join(" ", strArray);
    return result;
  }

}
