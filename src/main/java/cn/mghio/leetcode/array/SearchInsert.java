package cn.mghio.leetcode.array;

/**
 * Given a sorted array of distinct integers and a target value, return the index if the target is
 * found. If not, return the index where it would be if it were inserted in order.
 *
 * @author mghio
 * @since 2022-01-03
 */
public class SearchInsert {

  /**
   * Return the index of the target is found.
   *
   * @param nums the num array
   * @param target the target value
   * @return the index of the target value
   */
  public int searchInsertSolution1(int[] nums, int target) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    int len = nums.length;
    if (nums[len - 1] < target) {
      return len;
    }

    // nums[len - 1] >= target
    int left = 0;
    int right = len - 1;
    while (left < right) {
      int mid = left + (right - left)/ 2;
      if (nums[mid] < target) {
        // [mid + 1, right]
        left = mid + 1;
      } else {
        // [left, mid]
        right = mid;
      }
    }

    return right;
  }

}
