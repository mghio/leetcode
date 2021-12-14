package cn.mghio.leetcode.thinking;

/**
 * Given an integer k, return the number of non-negative integers x have the property that f(x) =
 * k.
 *
 * @author mghio
 * @since 2021-12-14
 */
public class PreimageSizeFZF {

  /**
   * Given an integer k, return the number of non-negative integers x have the property that f(x) =
   * k.
   */
  public int preimageSizeFZF(int k) {
    if (k <= 0) {
      return 0;
    }
    return Long.valueOf(rightBound(k) - leftBound(k) + 1).intValue();
  }

  private long leftBound(int target) {
    long lo = 0;
    long hi = Long.MAX_VALUE;
    while (lo < hi) {
      long mid = lo + (hi - lo) / 2;
      long midTrailing = trailingZeroes(mid);
      if (midTrailing < target) {
        lo = mid + 1;
      } else if (midTrailing > target) {
        hi = mid;
      } else {
        hi = mid;
      }
    }
    return lo;
  }

  private long rightBound(int target) {
    long lo = 0;
    long hi = Long.MAX_VALUE;
    while (lo < hi) {
      long mid = lo + (hi - lo) / 2;
      long midTrailing = trailingZeroes(mid);
      if (midTrailing < target) {
        lo = mid + 1;
      } else if (midTrailing > target) {
        hi = mid;
      } else {
        lo = mid + 1;
      }
    }
    return lo - 1;
  }

  private int trailingZeroes(long n) {
    int ans = 0;
    for (long d = n; d / 5 > 0; d /= 5) {
      ans += d / 5;
    }
    return ans;
  }

}
