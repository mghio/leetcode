package cn.mghio.leetcode.array;

import java.util.Arrays;

/**
 * Given an array of meeting time intervals intervals where intervals[i] = [starti, endi], return
 * the minimum number of conference rooms required.
 *
 * @author mghio
 * @since 2022-02-24
 */
public class MinMeetingRooms {

  public int minMeetingRooms(int[][] meetings) {
    int n = meetings.length;
    int[] begin = new int[n];
    int[] end = new int[n];

    for (int i = 0; i < n; i++) {
      begin[i] = meetings[i][0];
      end[i] = meetings[i][1];
    }
    Arrays.sort(begin);
    Arrays.sort(end);

    // 扫描过程中的计数器
    int count = 0;
    // 双指针技巧
    int res = 0, i = 0, j = 0;
    while (i < n && j < n) {
      if (begin[i] < end[j]) {
        // 扫描到一个红点
        count++;
        i++;
      } else {
        // 扫描到一个绿点
        count--;
        j++;
      }
      // 记录扫描过程中的最大值
      res = Math.max(res, count);
    }

    return res;
  }

}
