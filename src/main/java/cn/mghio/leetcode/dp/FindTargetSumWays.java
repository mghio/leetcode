package cn.mghio.leetcode.dp;

/**
 * You are given an integer array nums and an integer target.
 *
 * You want to build an expression out of nums by adding one of the symbols '+' and '-' before each
 * integer in nums and then concatenate all the integers.
 *
 * @author mghio
 * @since 2022-02-24
 */
public class FindTargetSumWays {

  private int count = 0;

  public int findTargetSumWays(int[] nums, int target) {
    backtrack(nums, target, 0, 0);
    return count;
  }

  private void backtrack(int[] nums, int target, int index, int sum) {
    if (index == nums.length) {
      if (sum == target) {
        count++;
      }
    } else {
      backtrack(nums, target, index + 1, sum + nums[index]);
      backtrack(nums, target, index + 1, sum - nums[index]);
    }
  }

  public int findTargetSumWaysSolution2(int[] nums, int target) {
    int sum = 0;
    for (int num : nums) {
      sum += num;
    }

    int diff = sum - target;
    if (diff < 0 || diff % 2 != 0) {
      return 0;
    }

    int n = nums.length;
    int neg = diff / 2;
    int[] dp = new int[neg + 1];
    dp[0] = 1;
    for (int num : nums) {
      for (int j = neg; j >= num; j--) {
        dp[j] += dp[j - num];
      }
    }
    return dp[neg];
  }

}
