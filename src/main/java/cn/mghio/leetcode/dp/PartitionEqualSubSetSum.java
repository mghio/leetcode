package cn.mghio.leetcode.dp;

/**
 * Given a non-empty array nums containing only positive integers, find if the array can be
 * partitioned into two subsets such that the sum of elements in both subsets is equal.
 *
 * @author mghio
 * @since 2021-10-09
 */
public class PartitionEqualSubSetSum {

  /**
   * find if the array can be partitioned into two subsets such that the sum of elements in both
   * subsets is equal.
   *
   * @param nums the array
   * @return true can partition, Else false
   */
  public boolean canPartition(int[] nums) {
    if (nums == null || nums.length < 1) {
      return false;
    }

    int sum = 0;
    for (int num : nums) {
      sum += num;
    }
    // odd number, return false
    if ((sum & 1) == 1) {
      return false;
    }

    int target = sum >>> 1;
    int len = nums.length;
    boolean[][] dp = new boolean[len][target + 1];
    dp[0][0] = true;
    if (nums[0] <= target) {
      dp[0][nums[0]] = true;
    }

    for (int i = 1; i < len; i++) {
      for (int j = 0; j <= target; j++) {
        dp[i][j] = dp[i - 1][j];

        if (nums[i] == j) {
          dp[i][j] = true;
          continue;
        }

        if (nums[i] < j) {
          dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
        }
      }
    }

    return dp[len - 1][target];
  }

}
