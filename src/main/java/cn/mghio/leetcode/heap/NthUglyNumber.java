package java.cn.mghio.leetcode.heap;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * We call numbers that only contain prime factors 2, 3, and 5 as Ugly Numbers. Find the nth ugly
 * number in ascending order.
 *
 * @author mghio
 * @since 2021-10-04
 */
public class NthUglyNumber {

  /**
   * nth ugly number.
   *
   * @param n the nth
   * @return the nth ugly number
   */
  public int nthUglyNumber(int n) {
    int[] factors = {2, 3, 5};
    Set<Long> set = new HashSet<>();
    set.add(1L);
    PriorityQueue<Long> heap = new PriorityQueue<>();
    heap.add(1L);
    long uglyNumber = 0L;

    for (int i = 0; i < n; i++) {
      uglyNumber = heap.poll();
      for (int factor : factors) {
        long nextUglyNumber = uglyNumber * factor;
        if (set.add(nextUglyNumber)) {
          heap.offer(nextUglyNumber);
        }
      }
    }

    return (int) uglyNumber;
  }

}
