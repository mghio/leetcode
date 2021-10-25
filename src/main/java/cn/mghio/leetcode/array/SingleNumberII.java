package java.cn.mghio.leetcode.array;

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
  public int singleNumber(int[] nums) {
    if (nums == null || nums.length < 3) {
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

}
