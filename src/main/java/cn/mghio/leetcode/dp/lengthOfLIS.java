package java.cn.mghio.leetcode.dp;

/**
 * Given an integer array nums, return the length of the longest strictly increasing subsequence.
 *
 * A subsequence is a sequence that can be derived from an array by deleting some or no elements
 * without changing the order of the remaining elements. For example, [3,6,2,7] is a subsequence of
 * the array [0,3,1,6,2,2,7].
 *
 * @author mghio
 * @since 2021-10-29
 */
public class lengthOfLIS {

  /**
   * Find the length of the longest strictly increasing subsequence.
   *
   * @param nums the array
   * @return the length
   */
  public int lengthOfLIS(int[] nums) {
    if (nums == null || nums.length < 1) {
      return 0;
    }

    int[] dp = new int[nums.length];
    dp[0] = 1;
    int ans = 1;
    for (int i = 1; i < nums.length; i++) {
      dp[i] = 1;
      for (int j = 0; j < i; j++) {
        if (nums[i] > nums[j]) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
      ans = Math.max(ans, dp[i]);
    }
    return ans;
  }

}
