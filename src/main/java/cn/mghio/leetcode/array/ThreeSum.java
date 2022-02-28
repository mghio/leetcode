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
    return NSum.nSumTarget(nums, 3, 0, target);
  }

}
