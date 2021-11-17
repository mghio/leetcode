package cn.mghio.leetcode.array;

import java.util.HashSet;
import java.util.Set;

/**
 * Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in
 * the result must be unique and you may return the result in any order.
 *
 * @author mghio
 * @since 2021-11-17
 */
public class Intersection {

  /**
   * Return an array of their intersection.
   *
   * @param num1 the array
   * @param num2 the other array
   * @return the intersection
   */
  public int[] intersectionSolution1(int[] num1, int[] num2) {
    if (num1 == null || num2 == null || num1.length < 1 || num2.length < 1) {
      return new int[]{};
    }

    Set<Integer> ansSet = new HashSet<>();
    for (int i : num1) {
      for (int j : num2) {
        if (i == j) {
          ansSet.add(i);
          break;
        }
      }
    }

    int[] ans = new int[ansSet.size()];
    int index = 0;
    for (Integer num : ansSet) {
      ans[index++] = num;
    }

    return ans;
  }

}
