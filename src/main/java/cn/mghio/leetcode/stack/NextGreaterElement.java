package cn.mghio.leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * Next Greater Element I
 *
 * The next greater element of some element x in an array is the first greater element that is to
 * the right of x in the same array.
 *
 * @author mghio
 * @since 2022-03-10
 */
public class NextGreaterElement {

  public int[] nextGreaterElementSolution1(int[] nums1, int[] nums2) {
    if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
      return new int[]{};
    }

    Map<Integer, Integer> elementToIndex = new HashMap<>(nums2.length);
    for (int i = 0; i < nums2.length; i++) {
      elementToIndex.put(nums2[i], i);
    }

    int lenOfNums2 = nums2.length;
    int[] res = new int[nums1.length];
    for (int i = 0; i < nums1.length; i++) {
      int element = nums1[i];
      int startIndexInNums2 = elementToIndex.get(element);
      if (startIndexInNums2 < lenOfNums2 - 1) {
        for (int j = startIndexInNums2 + 1; j < nums2.length; j++) {
          if (nums2[j] > element) {
            res[i] = nums2[j];
            break;
          }
          if (j == nums2.length - 1) {
            res[i] = -1;
          }
        }
      } else {
        res[i] = -1;
      }
    }

    return res;
  }

  public int[] nextGreaterElementSolution2(int[] nums1, int[] nums2) {
    if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
      return new int[]{};
    }

    int lenOfNums1 = nums1.length;
    int lenOfNums2 = nums2.length;
    int[] res = new int[lenOfNums1];

    for (int i = 0; i < lenOfNums1; i++) {
      int j = 0;
      int curElement = nums1[i];

      while (j < lenOfNums2 && nums2[j] != curElement) {
        j++;
      }

      int k = j + 1;
      while (k < lenOfNums2 && nums2[k] < curElement) {
        k++;
      }

      res[i] = k < lenOfNums2 ? nums2[k] : -1;
    }

    return res;
  }

  public int[] nextGreaterElementSolution3(int[] nums1, int[] nums2) {
    if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
      return new int[]{};
    }

    Map<Integer, Integer> map = new HashMap<>();
    Deque<Integer> stack = new ArrayDeque<>();
    for (int i = nums2.length - 1; i >= 0; i--) {
      int num = nums2[i];
      while (!stack.isEmpty() && num >= stack.peek()) {
        stack.pop();
      }
      map.put(num, stack.isEmpty() ? -1 : stack.peek());
      stack.push(num);
    }

    int[] res = new int[nums1.length];
    for (int i = 0; i < nums1.length; i++) {
      res[i] = map.get(nums1[i]);
    }

    return res;
  }

}
