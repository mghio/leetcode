package cn.mghio.leetcode.binary;

/**
 * Given a non-empty array of integers nums, every element appears twice except for one. Find that
 * single one.
 *
 * You must implement a solution with a linear runtime complexity and use only constant
 * extra space.
 *
 * @author mghio
 * @since 2022-03-03
 */
public class SingleNumber {

  public int singleNumber(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    int ret = 0;
    for (int num : nums) {
      ret ^= num;
    }
    return ret;
  }

}
