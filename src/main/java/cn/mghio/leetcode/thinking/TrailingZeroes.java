package cn.mghio.leetcode.thinking;

/**
 * Given an integer n, return the number of trailing zeroes in n!.
 *
 * @author mghio
 * @since 2021-12-13
 */
public class TrailingZeroes {

  /**
   * Given an integer n, return the number of trailing zeroes in n!
   *
   * @param n the n number
   * @return the number of trailing zeroes
   */
  public int trailingZeroes(int n) {
    if (n <= 0) {
      return 0;
    }

    int ans = 0;
    long divisor = 5;
    while (divisor <= n) {
      ans += n / divisor;
      divisor *= 5;
    }

    return ans;
  }

}
