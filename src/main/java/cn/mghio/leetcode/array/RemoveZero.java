package cn.mghio.leetcode.array;

/**
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order
 * of the non-zero elements.
 *
 * @author mghio
 * @since 2022-03-09
 */
public class RemoveZero {

  public void moveZeroes(int[] nums) {
    if (nums == null || nums.length == 0) {
      return;
    }

    int len = nums.length;
    int slow = 0;
    int fast = 0;
    while (fast < len) {
      if (nums[fast] != 0) {
        nums[slow++] = nums[fast];
      }
      fast++;
    }

    for (int i = slow; i < len; i++) {
      nums[i] = 0;
    }
  }

}
