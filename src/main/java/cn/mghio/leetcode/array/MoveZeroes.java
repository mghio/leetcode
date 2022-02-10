package cn.mghio.leetcode.array;

/**
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order
 * of the non-zero elements.
 *
 * Note that you must do this in-place without making a copy of the array.
 *
 * @author mghio
 * @since 2022-02-09
 */
public class MoveZeroes {

  /**
   * Move all 0's to the end of it while maintaining the relative order of the non-zero elements.
   *
   * @param nums the source array
   */
  public void moveZeroes(int[] nums) {
    if (nums == null || nums.length == 0) {
      return;
    }

    int noZeroElementIndex = removeElement(nums, 0);
    for (; noZeroElementIndex < nums.length; noZeroElementIndex++) {
      nums[noZeroElementIndex] = 0;
    }
  }

  private int removeElement(int[] nums, int val) {
    int slow = 0;
    int fast = 0;

    while (fast < nums.length) {
      if (nums[fast] != val) {
        nums[slow] = nums[fast];
        slow++;
      }
      fast++;
    }

    return slow;
  }

}
