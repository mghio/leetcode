package cn.mghio.leetcode.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

/**
 * You are given an integer array nums that is sorted in non-decreasing order.
 *
 * Determine if it is possible to split nums into one or more subsequences such that both of the
 * following conditions are true:
 *
 * Each subsequence is a consecutive increasing sequence (i.e. each integer is exactly one more than
 * the previous integer). All subsequences have a length of 3 or more. Return true if you can split
 * nums according to the above conditions, or false otherwise.
 *
 * @author mghio
 * @since 2021-10-04
 */
public class IsPossibleSubSequence {

  /**
   * Determine if it is possible to split nums into one or more subsequences
   *
   * @param nums the array
   * @return true can split nums according to the subsequence, or false otherwise
   */
  public boolean isPossible(int[] nums) {
    if (nums == null || nums.length < 3) {
      return false;
    }

    Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
    for (int num : nums) {
      if (!map.containsKey(num)) {
        map.put(num, new PriorityQueue<>());
      }

      if (map.containsKey(num - 1)) {
        int preLength = map.get(num - 1).poll();
        if (map.get(num - 1).isEmpty()) {
          map.remove(num - 1);
        }
        map.get(num).offer(preLength + 1);
      } else {
        map.get(num).offer(1);
      }
    }

    for (Entry<Integer, PriorityQueue<Integer>> entry : map.entrySet()) {
      PriorityQueue<Integer> queue = entry.getValue();
      if (queue.peek() < 3) {
        return false;
      }
    }

    return true;
  }

}
