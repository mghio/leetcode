package cn.mghio.leetcode.doublepoint;

/**
 * Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such
 * that each unique element appears only once. The relative order of the elements should be kept the
 * same.
 *
 * @author mghio
 * @since 2022-02-27
 */
public class RemoveDuplicates {

  /**
   * Remove duplicates.
   *
   * @param nums the nums array
   * @return the after placing the final result in the first k slots of nums
   */
  public int removeDuplicates(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    int slow = 0;
    int fast = 0;
    while (fast < nums.length) {
      if (nums[fast] != nums[slow]) {
        nums[++slow] = nums[fast];
      }
      fast++;
    }
    return slow + 1;
  }

}
