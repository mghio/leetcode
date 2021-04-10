package cn.mghio.leetcode.array;

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 target。 找出该数组中满足其和 ≥ target
 * 的长度最小的连续子数组[numsl, numsl+1, ..., numsr-1, numsr]， 并返回其长度。
 * 如果不存在符合条件的子数组，返回 0。
 *
 * 进阶：如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(nlog(n)) 时间复杂度的解法。
 *
 * @author mghio
 * @since 2021-04-10
 */
public class MinSubArrayLen {

  public int minSubArrayLen(int target, int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    // 方法一：暴力解法
    int result = violentSolution(target, nums);

    return result;
  }

  private int violentSolution(int target, int[] nums) {
    int n = nums.length;
    int result = Integer.MAX_VALUE;
    for (int i = 0; i < n; i++) {
      int sum = 0;
      for (int j = i; j < n; j++) {
        sum += nums[j];
        if (sum >= target) {
          result = Math.min(result, j - i + 1);
          break;
        }
      }
    }

    return result == Integer.MAX_VALUE ? 0 : result;
  }

}
