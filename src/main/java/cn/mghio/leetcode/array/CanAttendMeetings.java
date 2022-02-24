package cn.mghio.leetcode.array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given an array of meeting time intervals where intervals[i] = [starti, endi], determine if a
 * person could attend all meetings.
 *
 * @author mghio
 * @since 2022-02-24
 */
public class CanAttendMeetings {

  public boolean canAttendMeetings(int[][] intervals) {
    if (intervals == null || intervals.length == 0) {
      return false;
    }

    Arrays.sort(intervals, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return o1[0] - o2[0];
      }
    });

    for (int i = 0; i < intervals.length - 1; i++) {
      if (intervals[i][1] > intervals[i + 1][0]) {
        return false;
      }
    }
    return true;
  }

}
