package cn.mghio.leetcode.dp;

/**
 * You are climbing a staircase. It takes n steps to reach the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * @author mghio
 * @since 2021-11-04
 */
public class ClimbStairs {

  /**
   * Return how many distinct ways can you climb to the top
   *
   * @param n the n
   * @return the result
   */
  public int climbStairsSolution1(int n) {
    if (n == 0) {
      return 0;
    }

    if (n == 1) {
      return 1;
    }

    if (n == 2) {
      return 2;
    }

    return climbStairsSolution1(n - 1) + climbStairsSolution1(n - 2);
  }

  /**
   * Return how many distinct ways can you climb to the top
   *
   * @param n the n
   * @return the result
   */
  public int climbStairsSolution2(int n) {
    int p = 0;
    int q = 0;
    int r = 1;

    for (int i = 1; i <= n; i++) {
      p = q;
      q = r;
      r = p + q;
    }

    return r;
  }

}
