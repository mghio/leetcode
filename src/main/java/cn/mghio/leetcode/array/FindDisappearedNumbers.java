package cn.mghio.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all
 * the integers in the range [1, n] that do not appear in nums.
 *
 * @author mghio
 * @since 2021-11-27
 */
public class FindDisappearedNumbers {

  /**
   * return an array of all the integers in the range [1, n] that do not appear in nums.
   *
   * @param nums the array
   * @return an array of all the integers in the range [1, n] that do not appear in nums
   */
  public List<Integer> findDisappearedNumbersSolution1(int[] nums) {
    List<Integer> ans = new ArrayList<>();
    if (nums == null || nums.length < 1) {
      return ans;
    }

    int n = nums.length;
    List<Integer> allNums = new ArrayList<>(nums.length);
    for (int i = 1; i <= n; i++) {
      allNums.add(i);
    }

    for (Integer num : nums) {
      allNums.remove(num);
    }

    return allNums;
  }

}
