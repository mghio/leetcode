package cn.mghio.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
 * and return an array of the non-overlapping intervals that cover all the intervals in the input.
 *
 * @author mghio
 * @since 2021-03-02
 */
public class MergeRange {

  public int[][] mergeSolution1(int[][] intervals) {
    if (intervals == null || intervals.length == 0) {
      return intervals;
    }

    // sort
    Arrays.sort(intervals, Comparator.comparingInt(arrA -> arrA[0]));

    List<int[]> list = new ArrayList<>();
    int[] fir = intervals[0];
    for (int i = 1; i < intervals.length; i++) {
      if (fir[1] >= intervals[i][0]) {
        fir[1] = Math.max(fir[1], intervals[i][1]);
      } else {
        list.add(fir);
        fir = intervals[i];
      }
    }
    list.add(fir);
    int[][] result = new int[list.size()][2];
    for (int i = 0; i < list.size(); i++) {
      result[i] = list.get(i);
    }
    return result;
  }

  public int[][] mergeSolution2(int[][] intervals) {
    if (intervals == null || intervals.length == 0) {
      return new int[0][2];
    }

    Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

    List<int[]> merged = new ArrayList<>();
    for (int[] interval : intervals) {
      int left = interval[0], right = interval[1];
      if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < left) {
        merged.add(interval);
      } else {
        merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], right);
      }
    }
    return merged.toArray(new int[merged.size()][]);
  }

}
