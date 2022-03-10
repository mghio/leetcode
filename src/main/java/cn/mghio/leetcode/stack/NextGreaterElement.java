package cn.mghio.leetcode.stack;

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

  public int[] nextGreaterElement(int[] nums1, int[] nums2) {
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

}
