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

  /**
   * Given an unsorted array of integers nums, return the length of the longest continuous
   * increasing subsequence.
   *
   * @param nums the num array
   * @return the length of longest
   */
  public int findLengthOfLCISSolution2(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    int res = 0;
    int len = nums.length;
    int start = 0;
    for (int i = 0; i < len; i++) {
      if (i > 0 && nums[i] >= nums[i - 1]) {
        start = i;
      }
      res = Math.max(res, i - start + 1);
    }

    return res;
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
