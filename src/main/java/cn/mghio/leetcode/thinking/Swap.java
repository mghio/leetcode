package java.cn.mghio.leetcode.thinking;

/**
 * Do not use the new variable, swap the values of the two variables.
 *
 * @author mghio
 * @since 2021-10-16
 */
public class Swap {

  /**
   * swap the values of  the two variables use arithmetic.
   *
   * @param a the a variable
   * @param b the b variable
   */
  public void swapUseArithmetic(int a, int b) {
    a = a + b;
    b = a - b;
    a = a - b;
  }

}
