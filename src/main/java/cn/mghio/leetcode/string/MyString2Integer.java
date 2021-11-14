package cn.mghio.leetcode.string;

/**
 * Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer
 * (similar to C/C++'s atoi function).
 *
 * @author mghio
 * @since 2021-10-17
 */
public class MyString2Integer {

  private static final int TEN = 10;

  /**
   * Convert string to int.
   *
   * @param s the string
   * @return the integer
   */
  public int strToInt(String s) {
    if (s == null) {
      return 0;
    }

    int len = s.length();
    char[] charArray = s.toCharArray();

    // 1. trim string whitespace
    int index = 0;
    while (index < len && charArray[index] == ' ') {
      index++;
    }

    // 2. if all string is whitespace
    if (index == len) {
      return 0;
    }

    // 3. store sign（positive or negative）
    int sign = 1;
    char firstChar = charArray[index];
    if (firstChar == '+') {
      index++;
    } else if (firstChar == '-') {
      index++;
      sign = -1;
    }

    // 4. do convert string to integer
    int res = 0;
    while (index < len) {
      char curChar = charArray[index];
      // 4.1 check if not a number，then break
      if (curChar > '9' || curChar < '0') {
        break;
      }

      // 4.2 The environment can only store 32-bit signed integers, so it needs to be judged in
      // advance: whether it is out of bounds after multiplying by 10
      int tem = curChar - '0';
      if (res > Integer.MAX_VALUE / TEN
          || (res == Integer.MAX_VALUE / TEN && (tem > Integer.MAX_VALUE % TEN))) {
        return Integer.MAX_VALUE;
      }
      if (res < Integer.MIN_VALUE / TEN
          || (res == Integer.MIN_VALUE / TEN && (tem > -(Integer.MIN_VALUE % TEN)))) {
        return Integer.MIN_VALUE;
      }

      // 4.3 Conversion is considered only when it is legal,
      // and the sign bit is multiplied in each step
      res = res * TEN + sign * tem;
      index++;
    }

    return res;
  }

}
