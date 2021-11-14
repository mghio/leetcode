package cn.mghio.leetcode.heap;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * The median is the middle value in an ordered integer list.
 *
 * If the size of the list is even, there is no middle value and the median is the mean of the two
 * middle values.
 *
 * For example, for arr = [2,3,4], the median is 3. For example, for arr = [2,3], the median is (2 +
 * 3) / 2 = 2.5.
 *
 * @author mghio
 * @since 2021-10-07
 */
public class MedianFinder {

  /**
   * Min heap, storing the larger half of the elements.
   */
  private final Queue<Integer> minHeap;

  /**
   * Max heap, storing the smaller half of the elements.
   */
  private final Queue<Integer> maxHeap;

  public MedianFinder() {
    // default is min heap
    minHeap = new PriorityQueue<>();
    maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
  }

  /**
   * add the given num.
   *
   * @param num the num value
   */
  public void addNum(int num) {
    if (maxHeap.size() == minHeap.size() + 1) {
      maxHeap.offer(num);
      minHeap.offer(maxHeap.poll());
    } else {
      minHeap.offer(num);
      maxHeap.offer(minHeap.poll());
    }
  }

  /**
   * find the median.
   *
   * @return the median value
   */
  @SuppressWarnings("all")
  public double findMedian() {
    if (maxHeap.size() > minHeap.size()) {
      return maxHeap.peek();
    } else {
      return (minHeap.peek() + maxHeap.peek()) / 2.0;
    }
  }

}
