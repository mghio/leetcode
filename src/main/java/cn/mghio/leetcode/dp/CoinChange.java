package cn.mghio.leetcode.dp;

import java.util.Arrays;

/**
 * You are given an integer array coins representing coins of different denominations and an integer
 * amount representing a total amount of money.
 *
 * Return the fewest number of coins that you need to make up that amount. If that amount of money
 * cannot be made up by any combination of the coins, return -1.
 *
 * You may assume that you have an infinite number of each kind of coin.
 *
 * @author mghio
 * @since 2021-10-09
 */
public class CoinChange {

  /**
   * Coin change.
   *
   * @param coins the coin array
   * @param count the sum count
   * @return the number of coin
   */
  public int coinChange(int[] coins, int count) {
    int max = count + 1;
    int[] dp = new int[count + 1];
    Arrays.fill(dp, max);
    dp[0] = 0;
    for (int i = 1; i < count; i++) {
      for (int coin : coins) {
        if (coin <= i) {
          dp[i] = Math.min(dp[i], dp[i - coin] + 1);
        }
      }
    }

    return dp[count] > count ? -1 : dp[count];
  }

}
