package cn.mghio.leetcode.array;

/**
 * Given an array of integers nums sorted in non-decreasing order, find the starting and ending
 * position of a given target value.
 *
 * If target is not found in the array, return [-1, -1].
 *
 * @author mghio
 * @since 2022-01-03
 */
public class SearchRange {

  /**
   * Given an array of integers nums sorted in non-decreasing order, find the starting and ending
   * position of a given target value.
   *
   * @param nums the nums array
   * @param target the target value
   * @return the result
   */
  public int[] searchRange(int[] nums, int target) {
    int leftIndex = binarySearch(nums, target, true);
    int rightIndex = binarySearch(nums, target, false) - 1;

    if (leftIndex <= rightIndex
        && rightIndex < nums.length
        && nums[leftIndex] == target
        && nums[rightIndex] == target) {
      return new int[]{leftIndex, rightIndex};
    }

    return new int[]{-1, -1};
  }

  /**
   * Find target index in nums array.
   *
   * @param nums the num array
   * @param target the target value
   * @param lower If lower is true, find the first subscript greater than or equal to target,
   * otherwise find the first subscript greater than target
   * @return the target index
   */
  private int binarySearch(int[] nums, int target, boolean lower) {
    int left = 0;
    int right = nums.length - 1;
    int ans = nums.length;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] > target || (lower && nums[mid] >= target)) {
        right = mid - 1;
        ans = mid;
      } else {
        left = mid + 1;
      }
    }
    return ans;
  }

}
