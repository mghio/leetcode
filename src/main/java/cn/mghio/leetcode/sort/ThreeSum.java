package java.cn.mghio.leetcode.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i !=
 * j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 *
 * Notice that the solution set must not contain duplicate triplets.
 *
 * @author mghio
 * @since 2021-10-24
 */
public class ThreeSum {

  /**
   * Given an array, return all the triplets [nums[i], nums[j], nums[k]] such that i != * j, i != k,
   * and j != k, and nums[i] + nums[j] + nums[k] == 0.
   *
   * @param nums the array
   * @return the triplets
   */
  public List<List<Integer>> threeSumSolution1(int[] nums) {
    if (nums == null || nums.length < 3) {
      return Collections.emptyList();
    }

    int len = nums.length;
    Arrays.sort(nums);
    List<List<Integer>> ans = new ArrayList<>();
    for (int i = 0; i < len; i++) {
      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }
      int k = len - 1;
      int target = -nums[i];
      for (int j = i + 1; j < len; j++) {
        if (j > i + 1 && nums[j] == nums[j - 1]) {
          continue;
        }
        while (j < k && nums[j] + nums[k] > target) {
          --k;
        }
        if (j == k) {
          continue;
        }
        if (nums[j] + nums[k] == target) {
          List<Integer> list = new ArrayList<>();
          list.add(nums[i]);
          list.add(nums[j]);
          list.add(nums[k]);
          ans.add(list);
        }
      }
    }

    return ans;
  }

}
