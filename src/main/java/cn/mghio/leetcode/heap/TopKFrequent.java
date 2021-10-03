package java.cn.mghio.leetcode.heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.PriorityQueue;

/**
 * Given an integer array nums and an integer k, return the k most frequent elements. You may return
 * the answer in any order.
 *
 * @author mghio
 * @since 2021-10-03
 */
public class TopKFrequent {

  /**
   * Given an integer array nums, return the top K frequent array.
   *
   * @param nums the array numbers
   * @param k the top k
   * @return the top K frequent array
   */
  public int[] topKFrequent(int[] nums, int k) {
    // <num, cnt>
    Map<Integer, Integer> occurrences = new HashMap<>();
    for (int num : nums) {
      occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
    }

    // [0] - num，[1] - cnt
    // small top heap
    PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(p -> p[1]));
    for (Entry<Integer, Integer> entry : occurrences.entrySet()) {
      int num = entry.getKey();
      int cnt = entry.getValue();

      if (queue.size() == k) {
        if (Objects.requireNonNull(queue.peek())[1] < cnt) {
          queue.poll();
          queue.offer(new int[]{num, cnt});
        }
      } else {
        queue.offer(new int[] {num, cnt});
      }
    }

    int[] ret = new int[k];
    for (int i = 0; i < k; i++) {
      ret[i] = Objects.requireNonNull(queue.poll())[0];
    }

    return ret;
  }

}
