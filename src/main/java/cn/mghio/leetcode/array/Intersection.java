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

    return set2IntArray(ansSet);
  }

  /**
   * Return an array of their intersection.
   *
   * @param nums1 the array
   * @param nums2 the other array
   * @return the intersection
   */
  public int[] intersectionSolution2(int[] nums1, int[] nums2) {
    if (nums1 == null || nums2 == null || nums1.length < 1 || nums2.length < 1) {
      return new int[]{};
    }

    Set<Integer> num1Set = new HashSet<>();
    for (int num : nums1) {
      num1Set.add(num);
    }

    Set<Integer> ansSet = new HashSet<>();
    for (int num : nums2) {
      if (num1Set.contains(num)) {
        ansSet.add(num);
      }
    }

    return set2IntArray(ansSet);
  }

  private int[] set2IntArray(Set<Integer> ansSet) {
    int[] ans = new int[ansSet.size()];
    int index = 0;
    for (Integer num : ansSet) {
      ans[index++] = num;
    }
    return ans;
  }

}
