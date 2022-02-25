package cn.mghio.leetcode.array;

/**
 * Given a non-empty array nums containing only positive integers, find if the array can be
 * partitioned into two subsets such that the sum of elements in both subsets is equal.
 *
 * @author mghio
 * @since 2022-02-25
 */
public class CanPartition {

  public boolean canPartition(int[] nums) {
    int len = nums.length;
    int sum = 0;
    for (int num : nums) {
      sum += num;
    }
    if ((sum & 1) == 1) {
      return false;
    }

    int target = sum << 1;
    boolean[][] dp = new boolean[len][target + 1];
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

  public boolean canPartitionSolution(int[] nums) {
    int len = nums.length;
    int sum = 0;
    for (int num : nums) {
      sum += num;
    }
    if ((sum & 1) == 1) {
      return false;
    }

    int target = sum / 2;
    boolean[] dp = new boolean[target + 1];
    dp[0] = true;

    if (nums[0] <= target) {
      dp[nums[0]] = true;
    }
    for (int i = 1; i < len; i++) {
      for (int j = target; nums[i] <= j; j--) {
        if (dp[target]) {
          return true;
        }
        dp[j] = dp[j] || dp[j - nums[i]];
      }
    }
    return dp[target];
  }

}
