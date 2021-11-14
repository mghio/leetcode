package cn.mghio.leetcode.array;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Given an integer array nums where every element appears three times except for one, which appears
 * exactly once. Find the single element and return it.
 *
 * You must implement a solution with a linear runtime complexity and use only constant extra
 * space.
 *
 * @author mghio
 * @since 2021-10-25
 */
public class SingleNumberII {

  /**
   * Find the single element and return it.
   *
   * @param nums the array
   * @return the number
   */
  public int singleNumberSolution1(int[] nums) {
    if (nums == null || nums.length < 1) {
      return 0;
    }

    // <element, count>
    Map<Integer, Integer> freq = new HashMap<>();
    for (int num : nums) {
      freq.put(num, freq.getOrDefault(num, 0) + 1);
    }

    for (Entry<Integer, Integer> entry : freq.entrySet()) {
      if (entry.getValue() == 1) {
        return entry.getKey();
      }
    }

    return 0;
  }

  /**
   * Find the single element and return it.
   *
   * @param nums the array
   * @return the number
   */
  public int singleNumberSolution2(int[] nums) {
    if (nums == null || nums.length < 1) {
      return 0;
    }

    int ans = 0;
    for (int i = 0; i < 32; i++) {
      int total = 0;
      for (int num : nums) {
        total += ((num >> i) & 1);
      }
      if (total % 3 != 0) {
        ans |= (1 << i);
      }
    }
    return ans;
  }

}
