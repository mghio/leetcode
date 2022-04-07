package cn.mghio.leetcode.array;

/**
 * Search in Rotated Sorted Array.
 *
 * @author mghio
 * @since 2022-04-07
 */
public class SearchRotatedArray {

  public int search(int[] nums, int target) {
    if (nums == null || nums.length == 0) {
      return -1;
    }

    int k = -1;
    int len = nums.length;
    int curNum = nums[0];
    for (int i = 1; i < len; i++) {
      if (curNum > nums[i]) {
        k = i;
        break;
      }
      curNum = nums[i];
    }

    if (k == -1) {
      return binarySearch(target, nums, 0, len - 1);
    }

    int index = binarySearch(target, nums, 0, k - 1);
    return index == -1 ? binarySearch(target, nums, k, len - 1) : index;
  }

  private int binarySearch(int target, int[] nums, int begin, int end) {
    if (begin >= end) {
      return -1;
    }

    int mid = begin + (end - begin) / 2;
    if (nums[mid] > target) {
      end = mid;
    } else if (nums[mid] < target) {
      begin = mid + 1;
    } else {
      return mid;
    }

    return binarySearch(target, nums, begin, end);
  }

}
