package cn.mghio.leetcode.dp;

/**
 * The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such
 * that each number is the sum of the two preceding ones, starting from 0 and 1.
 *
 * @author mghio
 * @since 2021-11-20
 */
public class Fib {

  /**
   * Compute the Fibonacci numbers.
   *
   * @param n the n
   * @return the Fibonacci numbers
   */
  public int fib(int n) {
    if (n <= 0) {
      return 0;
    }

    if (n == 1 || n == 2) {
      return 1;
    }

    int prev = 1;
    int curr = 1;
    for (int i = 3; i <= n; i++) {
      int sum = prev + curr;
      prev = curr;
      curr = sum;
    }

    return curr;
  }

}
