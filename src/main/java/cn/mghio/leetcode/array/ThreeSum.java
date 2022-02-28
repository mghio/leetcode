package cn.mghio.leetcode.array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author mghio
 * @since 2022-02-28
 */
public class ThreeSum {

  public List<List<Integer>> threeSum(int[] nums) {
    if (nums == null || nums.length == 0) {
      return new LinkedList<>();
    }

    return threeSumTarget(nums, 0);
  }

  private List<List<Integer>> threeSumTarget(int[] nums, int target) {
    Arrays.sort(nums);

    // n 为 3，从 nums[0] 开始计算和为 target 的四元组
    return nSumTarget(nums, 3, 0, target);
  }

  private List<List<Integer>> nSumTarget(int[] nums, int n, int start, int target) {
    int sz = nums.length;
    List<List<Integer>> res = new LinkedList<>();
    // 至少是 2Sum，且数组大小不应该小于 n
    if (n < 2 || sz < n) {
      return res;
    }
    // 2Sum 是 base case
    if (n == 2) {
      // 双指针那一套操作
      int lo = start, hi = sz - 1;
      while (lo < hi) {
        int sum = nums[lo] + nums[hi];
        int left = nums[lo], right = nums[hi];
        if (sum < target) {
          while (lo < hi && nums[lo] == left) {
            lo++;
          }
        } else if (sum > target) {
          while (lo < hi && nums[hi] == right) {
            hi--;
          }
        } else {
          List<Integer> index = new LinkedList<>();
          index.add(left);
          index.add(right);
          res.add(index);
          while (lo < hi && nums[lo] == left) {
            lo++;
          }
          while (lo < hi && nums[hi] == right) {
            hi--;
          }
        }
      }
    } else {
      // n > 2 时，递归计算 (n-1)Sum 的结果
      for (int i = start; i < sz; i++) {
        List<List<Integer>> sub = nSumTarget(nums, n - 1, i + 1, target - nums[i]);
        for (List<Integer> arr : sub) {
          // (n-1)Sum 加上 nums[i] 就是 nSum
          arr.add(nums[i]);
          res.add(arr);
        }
        while (i < sz - 1 && nums[i] == nums[i + 1]) {
          i++;
        }
      }
    }
    return res;
  }

}
