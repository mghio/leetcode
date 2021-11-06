package java.cn.mghio.leetcode.dp;

/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 *
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a
 * different day in the future to sell that stock.
 *
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any
 * profit, return 0.
 *
 * @author mghio
 * @since 2021-11-06
 */
public class MaxProfit {

  /**
   * Return the maximum profit you can achieve from this transaction, if you cannot achieve any
   * profit, return 0.
   *
   * NOTE: timeout
   *
   * @param prices the prices array
   * @return the maximum profit
   */
  public int maxProfitSolution1(int[] prices) {
    if (prices == null || prices.length < 1) {
      return 0;
    }

    int maxProfit = 0;
    int n = prices.length;

    for (int i = 0; i < n - 1; i++) {
      for (int j = i + 1; j < n; j++) {
        if (prices[i] < prices[j]) {
         int curProfit = prices[j] - prices[i];
         if (curProfit > maxProfit) {
           maxProfit = curProfit;
         }
        }
      }
    }

    return maxProfit;
  }

}
