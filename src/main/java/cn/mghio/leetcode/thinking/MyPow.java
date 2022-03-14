package cn.mghio.leetcode.thinking;

/**
 * Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
 *
 * @author mghio
 * @since 2022-03-14
 */
public class MyPow {

  // NOTE: timeout
  public double pow(double x, int n) {
    if (n == 0) {
      return 1;
    }

    double ret = 1.0;
    int count = n > 0 ? n : -n;
    for (int i = 0; i < count; i++) {
      ret *= x;
    }
    return n > 0 ? ret : 1.0 / ret;
  }

  public double pow2(double x, int n) {
    long N = n;
    return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
  }

  private double quickMul(double x, long N) {
    if (N == 0) {
      return 1.0;
    }

    double y = quickMul(x, N / 2);
    return N % 2 == 0 ? y * y : y * y * x;
  }

}
