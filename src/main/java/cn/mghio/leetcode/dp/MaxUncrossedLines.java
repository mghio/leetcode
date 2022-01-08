package cn.mghio.leetcode.dp;

import java.util.Arrays;

/**
 * You are given two integer arrays nums1 and nums2. We write the integers of nums1 and nums2 (in
 * the order they are given) on two separate horizontal lines.
 *
 * @author mghio
 * @since 2022-01-08
 */
public class MaxUncrossedLines {

  private int[][] memo;

  /**
   * given two integer arrays nums1 and nums2. We write the integers of nums1 and nums2 (in the
   * order they are given) on two separate horizontal lines.
   *
   * @param nums1 the first array
   * @param nums2 the other array
   * @return the result
   */
  public int maxUncrossedLines(int[] nums1, int[] nums2) {
    if ((nums1 == null || nums1.length == 0) || (nums2 == null || nums2.length == 0)) {
      return 0;
    }

    memo = new int[nums1.length][nums2.length];
    for (int[] row : memo) {
      Arrays.fill(row, -1);
    }

    return dp(nums1, 0, nums2, 0);
  }

  /**
   * given two integer arrays nums1 and nums2. We write the integers of nums1 and nums2 (in the
   * order they are given) on two separate horizontal lines.
   *
   * @param nums1 the first array
   * @param nums2 the other array
   * @return the result
   */
  public int maxUncrossedLinesSolution2(int[] nums1, int[] nums2) {
    if ((nums1 == null || nums1.length == 0) || (nums2 == null || nums2.length == 0)) {
      return 0;
    }

    int m = nums1.length;
    int n = nums2.length;
    int[][] dp = new int[m + 1][n + 1];

    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        if (nums1[i - 1] == nums2[j - 1]) {
          dp[i][j] = dp[i - 1][j - 1] + 1;
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }

    return dp[m][n];
  }

  private int dp(int[] nums1, int i, int[] nums2, int j) {
    if (i == nums1.length || j == nums2.length) {
      return 0;
    }

    if (memo[i][j] != -1) {
      return memo[i][j];
    }

    if (nums1[i] == nums2[j]) {
      memo[i][j] = dp(nums1, i + 1, nums2, j + 1);
    } else {
      memo[i][j] = Math.max(dp(nums1, i + 1, nums2, j), dp(nums1, i, nums2, j + 1));
    }

    return memo[i][j];
  }

}
