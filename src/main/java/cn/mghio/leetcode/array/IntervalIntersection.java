package cn.mghio.leetcode.array;

import java.util.LinkedList;
import java.util.List;

/**
 * You are given two lists of closed intervals, firstList and secondList, where firstList[i] =
 * [starti, endi] and secondList[j] = [startj, endj]. Each list of intervals is pairwise disjoint
 * and in sorted order.
 *
 * @author mghio
 * @since 2022-02-20
 */
public class IntervalIntersection {

  /**
   * You are given two lists of closed intervals, firstList and secondList, where firstList[i] =
   * [starti, endi] and secondList[j] = [startj, endj]. Each list of intervals is pairwise disjoint
   * and in sorted order.
   *
   * @param firstList the first list
   * @param secondList the second list
   * @return the intersection of these two interval lists.
   */
  public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
    if (isEmpty(firstList) || isEmpty(secondList)) {
      return new int[0][0];
    }

    int i = 0;
    int j = 0;
    List<int[]> resList = new LinkedList<>();

    while (i < firstList.length && j < secondList.length) {
      int firstStart = firstList[i][0];
      int firstEnd = firstList[i][1];

      int secondStart = secondList[j][0];
      int secondEnd = secondList[j][1];

      if (secondEnd >= firstStart && firstEnd >= secondStart) {
        resList.add(new int[]{Math.max(firstStart, secondStart), Math.min(firstEnd, secondEnd)});
      }

      if (secondEnd > firstEnd) {
        i++;
      } else {
        j++;
      }
    }

    return resList.toArray(new int[0][]);
  }

  private boolean isEmpty(int[][] secondList) {
    return secondList == null || secondList.length == 0;
  }

}
