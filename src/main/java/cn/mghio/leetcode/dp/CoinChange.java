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

  private int[] memo;

  /**
   * Coin change.
   *
   * @param coins the coin array
   * @param count the sum count
   * @return the number of coin
   */
  public int coinChangeSolution2(int[] coins, int count) {
    if (count == 0) {
      return 0;
    }

    memo = new int[count + 1];
    Arrays.fill(memo, -2);

    return helper(coins, count);
  }

  /**
   * Coin change.
   *
   * @param coins the coin array
   * @param count the sum count
   * @return the number of coin
   */
  public int coinChangeSolution3(int[] coins, int count) {
    int[] dp = new int[count + 1];
    Arrays.fill(dp, Integer.MAX_VALUE);

    for (int i = 0; i < dp.length; i++) {
      for (int coin : coins) {
        if (i - coin < 0) {
          continue;
        }
        dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
      }
    }

    return dp[count] == Integer.MAX_VALUE ? -1 : dp[count];
  }

  private int helper(int[] coins, int count) {
    if (count == 0) {
      return 0;
    }

    if (memo[count] != -2) {
      return memo[count];
    }

    int res = Integer.MAX_VALUE;
    for (int coin : coins) {
      if (count - coin < 0) {
        continue;
      }
      int subProb = helper(coins, count - coin);
      if (subProb == -1) {
        continue;
      }
      res = Math.min(res, subProb + 1);
    }

    memo[count] = res == Integer.MAX_VALUE ? -1 : res;
    return memo[count];
  }

}
