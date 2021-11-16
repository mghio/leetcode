package cn.mghio.leetcode.array;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements
 * sequence.
 *
 * You must write an algorithm that runs in O(n) time.
 *
 * @author mghio
 * @since 2021-11-16
 */
public class LongestConsecutive {

  /**
   * Return the length of the longest consecutive elements sequence.
   *
   * @param nums the array
   * @return the longest consecutive elements sequence
   */
  public int longestConsecutive(int[] nums) {
    if (nums == null || nums.length < 1) {
      return 0;
    }

    Set<Integer> numSet = new HashSet<>();
    for (int num : nums) {
      numSet.add(num);
    }

    int longestStreak = 0;
    for (Integer num : numSet) {
      if (!numSet.contains(num - 1)) {
        int currNum = num;
        int currStreak = 1;

        while (numSet.contains(currNum + 1)) {
          currNum += 1;
          currStreak += 1;
        }

        longestStreak = Math.max(currStreak, longestStreak);
      }
    }

    return longestStreak;
  }

}
