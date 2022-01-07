package cn.mghio.leetcode.dp;

/**
 * Given an unsorted array of integers nums, return the length of the longest continuous increasing
 * subsequence (i.e. subarray). The subsequence must be strictly increasing.
 *
 * @author mghio
 * @since 2022-01-07
 */
public class FindLengthOfLCIS {

  /**
   * Given an unsorted array of integers nums, return the length of the longest continuous
   * increasing subsequence.
   *
   * @param nums the num array
   * @return the length of longest
   */
  public int findLengthOfLCIS(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    int len = nums.length;
    int[] dp = new int[len];
    dp[0] = 1;

    for (int i = 1; i < len; i++) {
      dp[i] = nums[i] > nums[i - 1] ? dp[i - 1] + 1 : 1;
    }

    return _findMax(dp);
  }

  private int _findMax(int[] dp) {
    int res = 0;
    for (int len : dp) {
      if (res < len) {
        res = len;
      }
    }
    return res;
  }

}
