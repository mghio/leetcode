package cn.mghio.leetcode.array;

/**
 * Given a non-empty array of integers nums, every element appears twice except for one. Find that
 * single one.
 *
 * You must implement a solution with a linear runtime complexity and use only constant extra
 * space.
 *
 * @author mghio
 * @since 2021-10-25
 */
public class singleNumber {

  /**
   * Given a non-empty array of integers nums, find that single one.
   *
   * @param nums the array
   * @return the single that one number
   */
  public int singleNumber(int[] nums) {
    if (nums == null || nums.length < 1) {
      return 0;
    }

    int result = 0;
    for (int num : nums) {
      result ^= num;
    }

    return result;
  }

}
