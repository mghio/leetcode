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
 * @since 2021-11-15
 */
public class MergeRange {

  /**
   * Return an array of the non-overlapping intervals that cover all the intervals in the input.
   *
   * @param intervals the input array
   * @return the array of the non-overlapping intervals
   */
  public int[][] merge(int[][] intervals) {
    if (intervals == null || intervals.length < 1 || intervals[0].length < 1) {
      return new int[][]{};
    }

    Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
    List<int[]> merged = new ArrayList<>();
    for (int[] interval : intervals) {
      int l = interval[0];
      int r = interval[1];
      int curLastIndex = merged.size() - 1;
      if (merged.size() == 0 || merged.get(curLastIndex)[1] < l) {
        merged.add(new int[]{l, r});
      } else {
        merged.get(curLastIndex)[1] = Math.max(merged.get(curLastIndex)[1], r);
      }
    }
    return merged.toArray(new int[merged.size()][]);
  }

}
