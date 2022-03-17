package cn.mghio.leetcode.array;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Maximum Number of Eaten Apples.
 *
 * @author mghio
 * @since 2022-03-17
 */
public class EatenApples {

  /**
   * Greed: you should eat the apples with the shortest shelf life every day.
   *
   * NOTE: Using a priority queue, save (decay date, decay quantity), each time the first of the
   * team is the shortest remaining shelf life. Nodes that go out of line by the date of decay or if
   * the number of decay returns to zero (eaten up ahead of time).
   *
   * @param apples the apple array
   * @param days the day array
   * @return the maximum number of eaten apple
   */
  public int eatenApples(int[] apples, int[] days) {
    if (apples == null || days == null) {
      return 0;
    }

    int d = 0;
    int ret = 0;
    // Queue<decay date, decay quantity>
    Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(x -> x[0]));

    while (d < apples.length || !queue.isEmpty()) {
      // enqueue
      if (d < apples.length && apples[d] > 0) {
        queue.add(new int[]{d + days[d], apples[d]});
      }

      while (!queue.isEmpty() && (queue.peek()[0] <= d || queue.peek()[1] == 0)) {
        queue.poll();
      }

      if (!queue.isEmpty()) {
        // eat apple
        ret++;
        queue.peek()[1]--;
      }
      d++;
    }

    return ret;
  }

}
