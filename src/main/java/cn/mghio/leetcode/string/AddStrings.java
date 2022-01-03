package cn.mghio.leetcode.string;

/**
 * Given two non-negative integers, num1 and num2 represented as string, return the sum of num1 and
 * num2 as a string.
 *
 * @author mghio
 * @since 2022-01-03
 */
public class AddStrings {

  /**
   * Return the sum of num1 and num2 as a string.
   *
   * @param num1 the num1
   * @param num2 the num2
   * @return the sum
   */
  public String addStrings(String num1, String num2) {
    int len1 = num1.length();
    int len2 = num2.length();
    if (len1 < len2) {
      num1 = "0".repeat(len2 - len1) + num1;
    } else {
      num2 = "0".repeat(len1 - len2) + num2;
    }

    int carry = 0;
    StringBuilder ans = new StringBuilder();
    for (int i = num1.length() - 1; i >= 0; i--) {
      int result =
          Integer.parseInt(num1.charAt(i) + "") + Integer.parseInt(num2.charAt(i) + "") + carry;
      if (result >= 10) {
        ans.append(result % 10);
        carry = 1;
      } else {
        ans.append(result);
        carry = 0;
      }
    }

    if (carry == 1) {
      ans.append("1");
    }

    return ans.reverse().toString();
  }

  /**
   * Return the sum of num1 and num2 as a string.
   *
   * @param num1 the num1
   * @param num2 the num2
   * @return the sum
   */
  public String addStringsSolution2(String num1, String num2) {
    int i = num1.length() - 1;
    int j = num2.length() - 1;
    int carry = 0;
    StringBuilder sb = new StringBuilder();

    while (i >= 0 || j >= 0 || carry != 0) {
      int x = i >= 0 ? num1.charAt(i) - '0' : 0;
      int y = j >= 0 ? num2.charAt(j) - '0' : 0;
      int result = x + y + carry;
      sb.append(result % 10);
      carry = result / 10;
      i--;
      j--;
    }

    return sb.reverse().toString();
  }

}
