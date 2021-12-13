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

  /**
   * Given an integer n, return the number of trailing zeroes in n!
   *
   * @param n the n number
   * @return the number of trailing zeroes
   */
  public int trailingZeroesSolution2(int n) {
    if (n <= 0) {
      return 0;
    }

    int ans = 0;
    for (int d = n; d / 5 > 0; d /= 5) {
      ans += d / 5;
    }

    return ans;
  }

}
