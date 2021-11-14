package cn.mghio.leetcode.array;

/**
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two
 * integers m and n, representing the number of elements in nums1 and nums2 respectively.
 *
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 *
 * The final sorted array should not be returned by the function, but instead be stored inside the
 * array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote
 * the elements that should be merged, and the last n elements are set to 0 and should be ignored.
 * nums2 has a length of n.
 *
 * Constraints:
 *
 * nums1.length == m + n nums2.length == n 0 <= m, n <= 200 1 <= m + n <= 200 -109 <= nums1[i],
 * nums2[j] <= 109
 *
 * @author mghio
 * @since 2021-10-26
 */
public class Merge {

  /**
   * Given two integer arrays, return sorted array.
   *
   * @param nums1 the array
   * @param m the array length
   * @param nums2 the other array
   * @param n the other array length
   */
  public void mergeSolution1(int[] nums1, int m, int[] nums2, int n) {
    if (nums1 == null || nums2 == null) {
      return;
    }

    int index = 0;
    int[] ans = new int[m + n];
    int index1 = 0, index2 = 0;
    while (index1 < m && index2 < n) {
      if (nums1[index1] <= nums2[index2]) {
        ans[index++] = nums1[index1++];
      } else {
        ans[index++] = nums2[index2++];
      }
    }

    while (index1 <= m - 1) {
      ans[index++] = ans[index1++];
    }

    while (index2 <= n - 1) {
      ans[index2++] = ans[index2++];
    }

    System.arraycopy(ans, 0, nums1, 0, index);
  }

  /**
   * Given two integer arrays, return sorted array.
   *
   * @param nums1 the array
   * @param m the array length
   * @param nums2 the other array
   * @param n the other array length
   */
  public void mergeSolution2(int[] nums1, int m, int[] nums2, int n) {
    int p1 = m - 1, p2 = n - 1;
    int tail = m + n - 1;
    int cur;

    while (p1 >= 0 || p2 >= 0) {
      if (p1 == -1) {
        cur = nums2[p2--];
      } else if (p2 == -1) {
        cur = nums1[p1--];
      } else if (nums1[p1] > nums2[p2]) {
        cur = nums1[p1--];
      } else {
        cur = nums2[p2--];
      }
      nums1[tail--] = cur;
    }
  }

}
