package cn.mghio.leetcode.doublepoint;

/**
 * Given an integer array nums and an integer val, remove all occurrences of val in nums in-place.
 * The relative order of the elements may be changed.
 *
 * @author mghio
 * @since 2022-02-27
 */
public class RemoveElement {

  public int removeElement(int[] nums, int val) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    int slow = 0;
    int fast = 0;
    while (fast < nums.length) {
      if (nums[fast] != val) {
        nums[slow++] = nums[fast];
      }
      fast++;
    }

    return slow;
  }

}
