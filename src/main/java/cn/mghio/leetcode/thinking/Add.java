package cn.mghio.leetcode.thinking;

/**
 * Write a function to find the sum of two integers. The four arithmetic operations must not be used
 * in the function body.
 *
 * @author mghio
 * @since 2021-10-16
 */
public class Add {

  /**
   * Given a and b parameter, the sum
   *
   * @param a the a
   * @param b the b
   * @return the sum
   */
  public int add(int a, int b) {
    int sum, carry;
    do {
      sum = a ^ b;
      carry = (a & b) << 1;
      a = sum;
      b = carry;
    } while (b != 0);

    return a;
  }

}
