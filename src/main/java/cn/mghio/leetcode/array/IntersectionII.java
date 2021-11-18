package cn.mghio.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in
 * the result must appear as many times as it shows in both arrays and you may return the result in
 * any order.
 *
 * @author mghio
 * @since 2021-11-18
 */
public class IntersectionII {

  /**
   * Given two integer arrays nums1 and nums2, return an array of their intersection.
   *
   * @param nums1 the array
   * @param nums2 the other array
   * @return the array of their intersection
   */
  public int[] intersectionSolution1(int[] nums1, int[] nums2) {
    int[] x = preCheck(nums1, nums2);
    if (x != null) {
      return x;
    }

    Map<Integer, Integer> num1CntMap = new HashMap<>();
    Set<Integer> nums1Set = new HashSet<>();
    for (int num : nums1) {
      nums1Set.add(num);
      num1CntMap.put(num, num1CntMap.getOrDefault(num, 0) + 1);
    }

    Map<Integer, Integer> num2CntMap = new HashMap<>();
    List<Integer> ansList = new ArrayList<>();
    for (int num : nums2) {
      num2CntMap.put(num, num2CntMap.getOrDefault(num, 0) + 1);
      if (nums1Set.contains(num) && num2CntMap.getOrDefault(num, 0) <= num1CntMap.getOrDefault(num,
          1)) {
        ansList.add(num);
      }
    }

    int[] ans = new int[ansList.size()];
    int index = 0;
    for (Integer num : ansList) {
      ans[index++] = num;
    }

    return ans;
  }

  /**
   * Given two integer arrays nums1 and nums2, return an array of their intersection.
   *
   * @param nums1 the array
   * @param nums2 the other array
   * @return the array of their intersection
   */
  public int[] intersectionSolution2(int[] nums1, int[] nums2) {
    int[] x = preCheck(nums1, nums2);
    if (x != null) {
      return x;
    }

    if (nums1.length > nums2.length) {
      return intersectionSolution2(nums2, nums1);
    }

    Map<Integer, Integer> numCntMap = new HashMap<>();
    for (int num : nums1) {
      numCntMap.put(num, numCntMap.getOrDefault(num, 0) + 1);
    }

    int[] ans = new int[nums1.length];
    int index = 0;
    for (int num : nums2) {
      int count = numCntMap.getOrDefault(num, 0);
      if (count > 0) {
        ans[index++] = num;
        count--;
        if (count > 0) {
          numCntMap.put(num, count);
        } else {
          numCntMap.remove(num);
        }
      }
    }

    return Arrays.copyOfRange(ans, 0, index);
  }

  /**
   * Given two integer arrays nums1 and nums2, return an array of their intersection.
   *
   * @param nums1 the array
   * @param nums2 the other array
   * @return the array of their intersection
   */
  public int[] intersectionSolution3(int[] nums1, int[] nums2) {
    int[] x = preCheck(nums1, nums2);
    if (x != null) {
      return x;
    }

    Arrays.sort(nums1);
    Arrays.sort(nums2);

    int ptr1 = 0;
    int ptr2 = 0;
    int index = 0;
    int[] ans = new int[Math.min(nums1.length, nums2.length)];
    while (ptr1 < nums1.length && ptr2 < nums2.length) {
      int num1 = nums1[ptr1];
      int num2 = nums2[ptr2];
      if (num1 < num2) {
        ptr1++;
      } else if (num1 > num2) {
        ptr2++;
      } else {
        ans[index++] = num1;
        ptr1++;
        ptr2++;
      }
    }

    return Arrays.copyOfRange(ans, 0, index);
  }

  private int[] preCheck(int[] nums1, int[] nums2) {
    if (nums1 == null || nums1.length < 1 || nums2 == null || nums2.length < 1) {
      return new int[]{};
    }
    return null;
  }

}
