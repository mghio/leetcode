package cn.mghio.leetcode.thinking;

/**
 * Hamming Distance.
 *
 * @author mghio
 * @since 2022-04-04
 */
public class HammingDistance {

  public int hammingDistance(int x, int y) {
    int xorResult = x ^ y;
    int ret = 0;
    while (xorResult != 0) {
      xorResult &= xorResult - 1;
      ret++;
    }
    return ret;
  }

  public int hammingDistance2(int x, int y) {
    return Integer.bitCount(x ^ y);
  }

}
