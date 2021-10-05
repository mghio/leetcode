package java.cn.mghio.leetcode.heap;

import java.util.PriorityQueue;

/**
 * @author mghio
 * @since 2021-10-05
 */
public class KthLargest {

  private PriorityQueue<Integer> queue;
  private int heapSize;

  public KthLargest(int k, int[] nums) {
    this.heapSize = k;
    queue = new PriorityQueue<>();
    for (int num : nums) {
      queue.offer(num);
    }
  }

  public int add(int val) {
    queue.offer(val);
    if (queue.size() > heapSize) {
      queue.poll();
    }
    return queue.peek();
  }

}
