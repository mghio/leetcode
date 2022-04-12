package cn.mghio.leetcode.thinking;

/**
 * number of 1's in binary.
 *
 * @author mghio
 * @since 2022-04-12
 */
public class HammingWeight {

  public int hammingWeight(int n) {
    int ret = 0;
    while (n != 0) {
      n &= n - 1;
      ret++;
    }
    return ret;
  }

}
