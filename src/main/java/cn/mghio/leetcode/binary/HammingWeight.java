package cn.mghio.leetcode.binary;

/**
 * Write a function that takes an unsigned integer and returns the number of '1' bits it has (also
 * known as the Hamming weight).
 *
 * @author mghio
 * @since 2022-03-03
 */
public class HammingWeight {

  public int hammingWeight(int n) {
    int res = 0;
    for (int i = 0; i < 32; i++) {
      if ((n & (1 << i)) != 0) {
        res++;
      }
    }
    return res;
  }

  public int hammingWeightSolution2(int n) {
    int res = 0;
    while (n != 0) {
      n &= n - 1;
    }
    return res;
  }

}
