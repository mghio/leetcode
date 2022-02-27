package cn.mghio.leetcode.doublepoint;

/**
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order
 * of the non-zero elements.
 *
 * @author mghio
 * @since 2022-02-27
 */
public class MoveZeroes {

  public void moveZeros(int[] nums) {
    if (nums == null || nums.length == 0) {
      return;
    }

    int slow = 0;
    int fast = 0;
    while (fast < nums.length) {
      if (nums[fast] != 0) {
        nums[slow++] = nums[fast];
      }
      fast++;
    }

    for (int i = slow; i < nums.length; i++) {
      nums[i] = 0;
    }
  }

}
