package cn.mghio.leetcode.array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given an array intervals where intervals[i] = [li, ri] represent the interval [li, ri), remove
 * all intervals that are covered by another interval in the list.
 *
 * @author mghio
 * @since 2022-02-19
 */
public class RemoveCoveredIntervals {

  /**
   * Given an array intervals where intervals[i] = [li, ri] represent the interval [li, ri), remove
   * all intervals that are covered by another interval in the list.
   *
   * @param intervals the intervals
   * @return the number of remaining intervals
   */
  public int removeCoveredInterval(int[][] intervals) {
    if (intervals == null || intervals.length == 0) {
      return 0;
    }

    Arrays.sort(intervals, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        if (o1[0] == o2[0]) {
          return o2[1] - o1[1];
        }
        return o1[0] - o2[0];
      }
    });

    int left = intervals[0][0];
    int right = intervals[0][1];

    int res = 0;
    for (int i = 1; i < intervals.length; i++) {
      int[] interval = intervals[i];

      // case 1: find the covered interval
      if (left <= interval[0] && right >= interval[1]) {
        res++;
      }

      // case 2: find the intersecting interval, then merge
      if (right >= interval[0] && right <= interval[1]) {
        right = interval[1];
      }

      // case 3: Completely disjoint, update start and end points
      if (right < interval[0]) {
        left = interval[0];
        right = interval[1];
      }
    }

    return intervals.length - res;
  }

}
