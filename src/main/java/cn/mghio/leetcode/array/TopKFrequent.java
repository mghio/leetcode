package cn.mghio.leetcode.array;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

/**
 * Given an integer array nums and an integer k, return the k most frequent elements. You may return
 * the answer in any order.
 *
 * @author mghio
 * @since 2022-03-13
 */
public class TopKFrequent {

  public int[] topKFrequent(int[] nums, int k) {
    if (nums == null || nums.length == 0 || k < 0) {
      return new int[]{};
    }

    Map<Integer, Integer> numToFreq = new HashMap<>();
    for (int num : nums) {
      numToFreq.put(num, numToFreq.getOrDefault(num, 0) + 1);
    }

    // minimum heap
    PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));

    for (Entry<Integer, Integer> entry : numToFreq.entrySet()) {
      int num = entry.getKey();
      int freq = entry.getValue();
      int[] newEntry = new int[]{num, freq};

      if (queue.size() == k) {
        if (queue.peek()[1] < freq) {
          queue.poll();
          queue.offer(newEntry);
        }
      } else {
        queue.offer(newEntry);
      }
    }

    int[] res = new int[k];
    for (int i = 0; i < k; i++) {
      res[i] = queue.poll()[0];
    }

    return res;
  }

}
