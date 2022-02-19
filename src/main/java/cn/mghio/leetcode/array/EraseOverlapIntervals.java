package cn.mghio.leetcode.array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given an array of intervals intervals where intervals[i] = [starti, endi], return the minimum
 * number of intervals you need to remove to make the rest of the intervals non-overlapping.
 *
 * @author mghio
 * @since 2022-02-19
 */
public class EraseOverlapIntervals {

  /**
   * Given an array of intervals intervals where intervals[i] = [starti, endi], return the minimum
   * number of intervals you need to remove to make the rest of the intervals non-overlapping.
   *
   * @param intervals the intervals
   * @return the minimum number of intervals
   */
  public static int eraseOverlapIntervals(int[][] intervals) {
    if (intervals == null || intervals.length == 0) {
      return 0;
    }

    int n = intervals.length;
    return n - intervalSchedule(intervals);
  }

  private static int intervalSchedule(int[][] intervals) {
    // sort
    Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));

    int res = 1;
    int end = intervals[0][1];
    for (int[] interval : intervals) {
      int start = interval[0];
      if (start >= end) {
        res++;
        end = interval[1];
      }
    }
    return res;
  }

  /**
   * Given an array of intervals intervals where intervals[i] = [starti, endi], return the minimum
   * number of intervals you need to remove to make the rest of the intervals non-overlapping.
   *
   * @param intervals the intervals
   * @return the minimum number of intervals
   */
  public static int eraseOverlapIntervalsSolution2(int[][] intervals) {
    if (intervals == null || intervals.length == 0) {
      return 0;
    }

    Arrays.sort(intervals, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return o1[0] - o2[0];
      }
    });

    int n = intervals.length;
    int[] dp = new int[n];
    Arrays.fill(dp, 1);
    for (int i = 1; i < n; i++) {
      for (int j = 0; j < i; j++) {
        if (intervals[j][1] <= intervals[i][0]) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
    }

    int max = dp[0];
    for (int i = 1; i < n; i++) {
      if (max < dp[i]) {
       max = dp[i];
      }
    }

    return n - max;
  }

}
