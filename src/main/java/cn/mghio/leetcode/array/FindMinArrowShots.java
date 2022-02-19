package cn.mghio.leetcode.array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given the array points, return the minimum number of arrows that must be shot to burst all
 * balloons.
 *
 * @author mghio
 * @since 2022-02-19
 */
public class FindMinArrowShots {

  /**
   * Given the array points, return the minimum number of arrows that must be shot to burst all
   * balloons.
   *
   * @param points the points array
   * @return the minimum number of arrows
   */
  public int findMinArrowShots(int[][] points) {
    if (points == null || points.length == 0) {
      return 0;
    }

    Arrays.sort(points, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return Integer.compare(o1[1], o2[1]);
      }
    });

    int res = 1;
    int end = points[0][1];
    for (int[] point : points) {
      int start = point[0];
      if (end < start) {
        res++;
        end = point[1];
      }
    }

    return res;
  }

}
