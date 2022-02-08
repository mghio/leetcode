package cn.mghio.leetcode.array;

/**
 * Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such
 * that each unique element appears only once. The relative order of the elements should be kept the
 * same.
 *
 * @author mghio
 * @since 2021-11-28
 */
public class RemoveDuplicates {

  /**
   * Remove duplicates element of given array.
   *
   * @param nums the array
   * @return the new length
   */
  public int removeDuplicates(int[] nums) {
    if (nums == null || nums.length < 1) {
      return 0;
    }

    int p = 0;
    int q = 1;
    while (q < nums.length) {
      if (nums[p] != nums[q]) {
        nums[++p] = nums[q];
      }
      q++;
    }

    return q + 1;
  }

  /**
   * Remove duplicates element of given array.
   *
   * @param nums the array
   * @return the new length
   */
  public int removeDuplicatesSolution2(int[] nums) {
    if (nums == null || nums.length < 1) {
      return 0;
    }

    int slow = 0;
    int fast = 0;
    while (fast < nums.length) {
      if (nums[slow] != nums[fast]) {
        nums[++slow] = nums[fast];
      }
      fast++;
    }

    return slow + 1;
  }

}
