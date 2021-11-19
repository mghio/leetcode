package cn.mghio.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer array nums of unique elements, return all possible subsets (the power set).
 *
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 *
 * @author mghio
 * @since 2021-11-19
 */
public class SubSets {

  /**
   * Return all possible subsets (the power set).
   *
   * @param nums the array nums
   * @return all possible subsets
   */
  public List<List<Integer>> subsets(int[] nums) {
    if (nums == null || nums.length < 1) {
      return new ArrayList<>();
    }

    List<Integer> t = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();

    int n = nums.length;
    for (int i = 0; i < 1 << n; i++) {
      t.clear();
      for (int j = 0; j < n; j++) {
        if ((i & (1 << j)) != 0) {
          t.add(nums[j]);
        }
      }
      ans.add(new ArrayList<>(t));
    }

    return ans;
  }

}
