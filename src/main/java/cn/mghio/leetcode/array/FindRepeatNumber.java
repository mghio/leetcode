package java.cn.mghio.leetcode.array;

/**
 * Find the repeated numbers in the array.
 *
 * All numbers in an array nums of length n are in the range of 0～n-1. Some numbers in the array are
 * repeated, but I don't know how many numbers are repeated, and I don't know how many times each
 * number is repeated. Please find any duplicate number in the array.
 *
 * @author mghio
 * @since 2021-10-10
 */
public class FindRepeatNumber {

  /**
   * Find the repeated numbers in the array.
   *
   * @param nums the array
   * @return the repeated number
   */
  public int findRepeatNumber(int[] nums) {
    if (nums == null || nums.length < 2) {
      return -1;
    }
    int len = nums.length;
    for (int num : nums) {
      if (num < 0 || num > len - 1) {
        return -1;
      }
    }

    for (int i = 0; i < len; i++) {
      while (nums[i] != i) {
        if (nums[i] == nums[nums[i]]) {
          return nums[i];
        }
        swap(nums, i, nums[i]);
      }
    }
    return -1;
  }

  private void swap(int[] nums, int sourceIndex, int targetIndex) {
    int tmp = nums[sourceIndex];
    nums[sourceIndex] = nums[targetIndex];
    nums[targetIndex] = tmp;
  }

}
