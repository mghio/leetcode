package cn.mghio.leetcode.string;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements
 * sequence.
 *
 * @author mghio
 * @since 2022-01-19
 */
public class LongestConsecutive {

  /**
   * Given an unsorted array of integers nums, return the length of the longest consecutive elements
   * sequence.
   *
   * @param nums the array
   * @return longest consecutive elements sequence
   */
  public int longestConsecutive(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    Set<Integer> numSet = new HashSet<>();
    for (int num : nums) {
      numSet.add(num);
    }

    int res = 0;
    for (int num : numSet) {
      if (!numSet.contains(num - 1)) {
        int curNum = num;
        int curLen = 1;

        while (numSet.contains(curNum + 1)) {
          curNum++;
          curLen++;
        }
        res = Math.max(res, curLen);
      }
    }

    return res;
  }

}
