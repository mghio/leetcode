package cn.mghio.leetcode.dp;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * You are given an array of events where events[i] = [startDayi, endDayi]. Every event i starts at
 * startDayi and ends at endDayi.
 *
 * You can attend an event i at any day d where startTimei <= d <= endTimei. You can only attend one
 * event at any time d.
 *
 * Return the maximum number of events you can attend.
 *
 * @author mghio
 * @since 2022-01-12
 */
public class MaxEvents {

  /**
   * Return the maximum number of events you can attend.
   *
   * @param events the arrays
   * @return the maximum number of events
   */
  public int maxEvents(int[][] events) {
    if (events == null || events.length == 0 || events[0].length == 0) {
      return 0;
    }

    int len = events.length;
    // sort by start day in ascending order
    Arrays.sort(events, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return o1[0] - o2[0];
      }
    });

    // Small top heap: for efficient maintenance with minimal endDay
    PriorityQueue<Integer> queue = new PriorityQueue<>();
    int res = 0;
    int currDay = 1;
    int i = 0;
    while (i < len || !queue.isEmpty()) {
      while (i < len && events[i][0] == currDay) {
        queue.add(events[i][1]);
        i++;
      }

      while (!queue.isEmpty() && queue.peek() < currDay) {
        queue.poll();
      }

      if (!queue.isEmpty()) {
        queue.remove();
        res++;
      }
      currDay++;
    }

    return res;
  }

}
