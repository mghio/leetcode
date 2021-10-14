package java.cn.mghio.leetcode.thinking;

/**
 * Seek 1+2+...+n. It is required that keywords such as multiplication and division, for, while, if,
 * else, switch, case and conditional judgment statements (A?B:C) cannot be used.
 *
 * @author mghio
 * @since 2021-10-14
 */
public class SumNums {

  /**
   * Sum of 1 to n.
   *
   * @param n the n
   * @return the sum
   */
  public int sumNums(int n) {
    boolean flag = n > 0 && (n += sumNums(n - 1))  > 0;
    return n;
  }

}
