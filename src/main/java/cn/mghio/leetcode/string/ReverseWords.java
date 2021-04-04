package cn.mghio.leetcode.string;

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

    String[] strArray = s.trim().split("\\s+");
    for (int i = 0, len = strArray.length; i < len / 2; i++) {
      String temp = strArray[i];
      strArray[i] = strArray[len - i - 1];
      strArray[len - i - 1] = temp;
    }

    return String.join(" ", strArray);
  }

}
