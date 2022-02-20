package cn.mghio.leetcode.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
 * and return an array of the non-overlapping intervals that cover all the intervals in the input.
 *
 * @author mghio
 * @since 2022-02-20
 */
public class MergeIntervals {

  /**
   * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping
   * intervals, and return an array of the non-overlapping intervals that cover all the intervals in
   * the input.
   *
   * @param intervals the intervals array
   * @return the array of the non-overlapping intervals
   */
  public static int[][] merge(int[][] intervals) {
    if (intervals == null || intervals.length == 0) {
      return new int[0][0];
    }

    Arrays.sort(intervals, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return Integer.compare(o1[0], o2[0]);
      }
    });

    List<int[]> list = new LinkedList<>();
    list.add(intervals[0]);

    for (int i = 1, len = intervals.length; i < len; i++) {
      int[] curInterval = intervals[i];
      int[] listLastInterval = list.get(list.size() - 1);

      if (curInterval[0] <= listLastInterval[1]) {
        listLastInterval[1] = Math.max(listLastInterval[1], curInterval[1]);
      } else {
        list.add(curInterval);
      }
    }

    return list.toArray(new int[0][]);
  }

  public static void main(String[] ags) {
    int[][] intervals = {{1,3}, {8,10}, {2,6}, {15,18}};
    int[][] res = merge(intervals);
    for (int[] interval : res) {
      System.out.println(Arrays.toString(interval));
    }

    System.out.println();

    int[][] intervals2 = {{1,4}, {4, 5}};
    int[][] res2 = merge(intervals2);
    for (int[] interval : res2) {
      System.out.println(Arrays.toString(interval));
    }
  }

}
