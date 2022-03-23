package cn.mghio.leetcode.array;

/**
 * Median of Two Sorted Arrays.
 *
 * @author mghio
 * @since 2022-03-23
 */
public class FindMedianSortedArrays {

  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int len1 = nums1.length;
    int len2 = nums2.length;
    int totalLen = len1 + len2;
    if (totalLen % 2 == 1) {
      int midIndex = totalLen / 2;
      return getKElement(nums1, nums2, midIndex + 1);
    } else {
      int midIndex1 = len1 / 2, midIndex2 = len2 / 2;
      return (getKElement(nums1, nums2, midIndex1 + 1) + getKElement(nums1, nums2, midIndex2 + 1)) / 2.0;
    }
  }

  private double getKElement(int[] nums1, int[] nums2, int k) {
    int len1 = nums1.length, len2 = nums2.length;
    int index1 = 0, index2 = 0;

    while (true) {
      // base case
      if (index1 == len1) {
        return nums2[index2 + k - 1];
      }
      if (index2 == len2) {
        return nums1[index1 + k - 1];
      }

      if (k == 1) {
        return Math.min(nums1[index1], nums2[index2]);
      }

      int halfK = k / 2;
      int newIndex1 = Math.min(index1 + halfK, len1) - 1;
      int newIndex2 = Math.min(index2 + halfK, len2) - 1;
      int pivot1 = nums1[newIndex1];
      int pivot2 = nums2[newIndex2];
      if (pivot1 < pivot2) {
        k -= newIndex1 - index1 + 1;
        index1 = newIndex1 + 1;
      } else {
        k -= newIndex2 - index2 + 1;
        index2 = newIndex2 + 1;
      }
    }
  }

}
