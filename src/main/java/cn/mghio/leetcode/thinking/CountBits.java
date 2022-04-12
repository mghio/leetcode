package cn.mghio.leetcode.thinking;

/**
 * Counting Bits.
 *
 * @author mghio
 * @since 2022-04-12
 */
public class CountBits {

  public int[] countBits(int n) {
    if (n < 0) {
      return new int[]{};
    }

    int[] ret = new int[n + 1];
    for (int i = 0; i <= n; i++) {
      int num = 0;
      int cur = i;
      while (cur > 0) {
        if ((cur & 1) != 0) {
          num++;
        }
        cur >>= 1;
      }
      ret[i] = num;
    }

    return ret;
  }

  public int[] countBits2(int n) {
    if (n < 0) {
      return new int[]{};
    }

    int[] ret = new int[n + 1];
    for (int i = 0; i <= n; i++) {
      int num = 0;
      int cur = i;
      while (cur != 0) {
        cur &= cur - 1;
        num++;
      }
      ret[i] = num;
    }

    return ret;
  }

  public int[] countBits3(int n) {
    if (n < 0) {
      return new int[]{};
    }

    int[] ret = new int[n + 1];
    for (int i = 0; i <= n; i++) {
      ret[i] = Integer.bitCount(i);
    }

    return ret;
  }

  public int[] countBits4(int n) {
    if (n < 0) {
      return new int[]{};
    }

    int highBit = 0;
    int[] ret = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      if ((i & (i - 1)) == 0) {
        highBit = i;
      }
      ret[i] = ret[i - highBit] + 1;
    }

    return ret;
  }

}
