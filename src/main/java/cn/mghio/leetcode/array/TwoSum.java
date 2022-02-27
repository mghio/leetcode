package cn.mghio.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mghio
 * @since 2021-12-04
 */
public class TwoSum {

  /**
   * Given an array and target, return two index of sum equals target
   *
   * @param nums the array
   * @param target the target
   * @return the index array
   */
  public int[] twoSum(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;

    while (left < right) {
      int sum = nums[left] + nums[right];

      if (sum == target) {
        return new int[]{left, right};
      } else if (sum < target) {
        left++;
      } else {
        right--;
      }
    }

    return new int[]{-1, -1};
  }

  /**
   * Given an array and target, return two index of sum equals target.
   *
   * @param nums the array
   * @param target the target
   * @return the index array
   */
  public int[] twoSumSolution2(int[] nums, int target) {
    if (nums == null || nums.length == 0) {
      return new int[]{-1, -1};
    }

    int len = nums.length;
    for (int i = 0; i < len; i++) {
      for (int j = i + 1; j < len; j++) {
        if (nums[j] == target - nums[i]) {
          return new int[]{i, j};
        }
      }
    }
    return new int[]{-1, -1};
  }

  /**
   * Given an array and target, return two index of sum equals target.
   *
   * @param nums the array
   * @param target the target
   * @return the index array
   */
  public int[] twoSumSolution3(int[] nums, int target) {
    if (nums == null || nums.length == 0) {
      return new int[]{-1, -1};
    }

    int len = nums.length;
    Map<Integer, Integer> numToIndexMap = new HashMap<>();
    for (int i = 0; i < len; i++) {
      numToIndexMap.put(nums[i], i);
    }

    for (int i = 0; i < len; i++) {
      int other = target - nums[i];
      if (numToIndexMap.containsKey(other) && numToIndexMap.get(other) != i) {
        return new int[]{i, numToIndexMap.get(other)};
      }
    }

    return new int[]{-1, -1};
  }

}
