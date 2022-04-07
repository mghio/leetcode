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

    int len = nums.length;
    if (len == 1) {
      return nums[0] == target ? 0 : -1;
    }

    int l = 0;
    int r = len - 1;
    while (l <= r) {
      int mid = l + (r - l) / 2;
      if (nums[mid] == target) {
        return mid;
      }

      if (nums[0] <= nums[mid]) {
        if (nums[0] <= target && target < nums[mid]) {
          r = mid - 1;
        } else {
          l = mid + 1;
        }
      } else {
        if (nums[mid] < target && target <= nums[len - 1]) {
          l = mid + 1;
        } else {
          r = mid - 1;
        }
      }
    }

    return -1;
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
