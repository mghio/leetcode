package cn.mghio.leetcode.array;

import java.util.Arrays;

/**
 * Given an integer n, return the number of prime numbers that are strictly less than n.
 *
 * @author mghio
 * @since 2021-11-23
 */
public class CountPrimes {

  /**
   * return the number of prime numbers that are strictly less than n.
   *
   * @param n the max number
   * @return the prime number
   */
  public int countPrimes(int n) {
    boolean[] isPrim = new boolean[n];
    Arrays.fill(isPrim, true);

    for (int i = 2; i * i < n; i++) {
      if (isPrim[i]) {
        for (int j = i * i; j < n; j += i) {
          isPrim[j] = false;
        }
      }
    }

    int count = 0;
    for (int i = 2; i < n; i++) {
      if (isPrim[i]) {
        count++;
      }
    }

    return count;
  }

}
