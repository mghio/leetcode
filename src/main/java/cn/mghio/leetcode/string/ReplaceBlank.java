package cn.mghio.leetcode.string;

/**
 * 替换空格
 *
 * 实现一个方法，把字符串中的每个空格替换成 "%20"，例如：输入 "We are happy"， 则输出 "We%20are%20happy"
 *
 * @author mghio
 * @since 2021-04-18
 */
public class ReplaceBlank {

  public String replaceBlank(String s) {
    if (s == null || s.length() == 0) {
      return "";
    }

    // Step 1. 统计字符串的长度和空格个数
    int originalLength = 0;
    int numberOfBlank = 0;
    char[] chars = s.toCharArray();
    for (char aChar : chars) {
      if (aChar == ' ') {
        numberOfBlank++;
      }
      originalLength++;
    }

    // Step 2. 替换空格后的新长度
    int newLength = originalLength + numberOfBlank * 2;
    int indexOfOriginal = originalLength - 1;
    int indexOfNew = newLength - 1;
    char[] newChars = new char[newLength];
    System.arraycopy(chars, 0, newChars, 0, chars.length);
    while (indexOfOriginal >= 0 && indexOfNew > indexOfOriginal) {
      if (newChars[indexOfOriginal] == ' ') {
        newChars[indexOfNew--] = '0';
        newChars[indexOfNew--] = '2';
        newChars[indexOfNew--] = '%';
      } else {
        newChars[indexOfNew--] = newChars[indexOfOriginal];
      }
      --indexOfOriginal;
    }
    return new String(newChars);
  }

}
