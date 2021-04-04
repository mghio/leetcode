package cn.mghio.leetcode.string;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
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
//    String result = getReverseWordWithLanguageFeature2(s);

    // 方法二：自行编写方法实现
//    String result = customAlgo(s);

    // 方法三：双端队列
    String result = getReverseWordWithDeque(s);

    return result;
  }

  /**
   * 方法三：双端队列法
   *
   * 时间复杂度：O(N)，其中 N 为输入字符串的长度。
   * 空间复杂度：O(N)，双端队列存储单词需要 O(N) 的空间。
   */
  private String getReverseWordWithDeque(String s) {
    int left = 0;
    int right = s.length() - 1;

    // 去除字符串左边空格
    while (left <= right && s.charAt(left) == ' ') {
      left++;
    }
    // 去除字符串右边空格
    while (left <= right && s.charAt(right) == ' ') {
      right--;
    }

    Deque<String> d = new ArrayDeque<>();
    StringBuilder word = new StringBuilder();
    while (left <= right) {
      char c = s.charAt(left);
      if ((word.length() != 0) && (c == ' ')) {
        // 将单词 push 到队列的头部
        d.offerFirst(word.toString());
        word.setLength(0);
      } else if (c != ' ') {
        word.append(c);
      }
      ++left;
    }
    d.offerFirst(word.toString());

    return String.join(" ", d);
  }

  /**
   * 方法二：自行编写方法实现
   *
   * 时间复杂度：O(N)，其中 N 为输入字符串的长度。
   * 空间复杂度：需要 O(N) 的空间来存储字符串，而 C++ 方法因为字符串可变只需要 O(1)O(1) 的额外空间来存放若干变量。
   */
  private String customAlgo(String s) {
    // Step 1: 去除多余空格，并转换为可变字符串（StringBuilder）
    StringBuilder sb = trimSpaceAndConvertToStringBuilder(s);
    // Step 2: 翻转字符串
    reverse(sb, 0, sb.length() - 1);
    // Step 3: 翻转每个单词
    reverseEachWord(sb);

    String result = sb.toString();
    return result;
  }

  /**
   * 翻转每个单词
   */
  private void reverseEachWord(StringBuilder sb) {
    int n = sb.length();
    int start = 0;
    int end = 0;
    while (start < n) {
      // 循环至单词的末尾
      while (end < n && sb.charAt(end) != ' ') {
        ++end;
      }
      // 翻转单词
      reverse(sb, start, end - 1);
      // 更新 start，去找下一个单词
      start = end + 1;
      end++;
    }
  }

  /**
   * 翻转字符串
   */
  private void reverse(StringBuilder sb, int left, int right) {
    while (left < right) {
      char temp = sb.charAt(left);
      sb.setCharAt(left++, sb.charAt(right));
      sb.setCharAt(right--, temp);
    }
  }

  /**
   * 去除首尾空格并转换为可变的字符串
   */
  private StringBuilder trimSpaceAndConvertToStringBuilder(String s) {
    int left = 0;
    int right = s.length() - 1;

    // 去除字符串开头的空白字符
    while (left <= right && s.charAt(left) == ' ') {
      left++;
    }
    // 去除字符串结尾的空白字符
    while (left <= right && s.charAt(right) == ' ') {
      right--;
    }

    // 将字符串多余的空格去除
    StringBuilder sb = new StringBuilder();
    while (left <= right) {
      char c = s.charAt(left);
      if (c != ' ') {
        sb.append(c);
      } else if (sb.charAt(sb.length() - 1) != ' ') {
        sb.append(c);
      }
      ++left;
    }
    return sb;
  }

  /**
   * 方法一：使用语言特性
   *
   * 时间复杂度：O(N)，其中 N 为输入字符串的长度。
   * 空间复杂度：O(N)，用来存储字符串分割之后的结果。
   */
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
