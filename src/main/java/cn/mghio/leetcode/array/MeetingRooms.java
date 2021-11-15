package cn.mghio.leetcode.array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given an array of meeting schedules, each meeting time will include the start and end time
 * [[s1,e1],[s2,e2],...] (si <ei), please judge whether a person can Attend all the meetings here.
 *
 * @author mghio
 * @since 2021-11-15
 */
public class MeetingRooms {

  /**
   * Judge whether a person can attend all the meeting here.
   *
   * @param intervals the meeting schedules array
   * @return true represent can attend all meetings, else false
   */
  public boolean canAttendMeetings(int[][] intervals) {
    if (intervals == null || intervals.length < 1 || intervals[0].length < 1) {
      return false;
    }

    Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

    for (int i = 0; i < intervals.length - 1; i++) {
      if (intervals[i][1] > intervals[i + 1][0]) {
        return false;
      }
    }

    return true;
  }

}
