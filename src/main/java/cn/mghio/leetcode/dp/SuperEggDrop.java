package cn.mghio.leetcode.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * You are given k identical eggs and you have access to a building with n floors labeled from 1 to
 * n.
 *
 * You know that there exists a floor f where 0 <= f <= n such that any egg dropped at a floor
 * higher than f will break, and any egg dropped at or below floor f will not break.
 *
 * Each move, you may take an unbroken egg and drop it from any floor x (where 1 <= x <= n). If the
 * egg breaks, you can no longer use it. However, if the egg does not break, you may reuse it in
 * future moves.
 *
 * Return the minimum number of moves that you need to determine with certainty what the value of f
 * is.
 *
 * @author mghio
 * @since 2021-12-15
 */
public class SuperEggDrop {

  private final Map<Integer, Integer> memo = new HashMap<>();

  /**
   * Return the minimum number of moves that you need to determine with certainty what the value of
   * f is.
   */
  public int superEggDrop(int k, int n) {
    if (n == 0) {
      return 0;
    }
    if (k == 1) {
      return n;
    }

    return dp(k, n);
  }

  private int dp(int k, int n) {
    if (!memo.containsKey(n * 100 + k)) {
      int ans;
      if (n == 0) {
        ans = 0;
      } else if (k == 1) {
        ans = n;
      } else {
        int lo = 1, hi = n;
        while (lo + 1 < hi) {
          int x = (lo + hi) / 2;
          int t1 = dp(k - 1, x - 1);
          int t2 = dp(k, n - x);

          if (t1 < t2) {
            lo = x;
          } else if (t1 > t2) {
            hi = x;
          } else {
            lo = hi = x;
          }
        }

        ans = 1 + Math.min(Math.max(dp(k - 1, lo - 1), dp(k, n - lo)),
            Math.max(dp(k - 1, hi - 1), dp(k, n - hi)));
      }

      memo.put(n * 100 + k, ans);
    }

    return memo.get(n * 100 + k);
  }

}
