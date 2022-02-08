package cn.mghio.leetcode.array;

/**
 * Given an integer array nums and an integer val, remove all occurrences of val in nums in-place.
 * The relative order of the elements may be changed.
 *
 * @author mghio
 * @since 2022-02-09
 */
public class RemoveElement {

  /**
   * Given an integer array nums and an integer val, remove all occurrences of val in nums in-place.
   * The relative order of the elements may be changed
   *
   * @param nums the array
   * @param val the value
   * @return the result array length
   */
  public int removeElement(int[] nums, int val) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

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
