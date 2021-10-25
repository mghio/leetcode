package java.cn.mghio.leetcode.array;

/**
 * Except for two numbers in an integer array nums, other numbers appear twice. Please write a
 * program to find these two numbers that only appear once. The required time complexity is O(n),
 * and the space complexity is O(1).
 *
 * @author mghio
 * @since 2021-10-25
 */
public class SingleNumbers {

  /**
   * Given an array, find these two numbers that only appear once.
   *
   * @param nums the array
   * @return the only appear once number
   */
  public int[] singleNumbers(int[] nums) {
    if (nums == null || nums.length < 2) {
      return new int[]{0, 0};
    }

    int result = 0;
    for (int num : nums) {
      result ^= num;
    }

    int target = 1;
    while ((target & result) == 0) {
      target <<= 1;
    }

    int[] ret = new int[]{0, 0};
    for (int num : nums) {
      if ((num & target) == 0) {
        ret[0] ^= num;
      } else {
        ret[1] ^= num;
      }
    }
    return ret;
  }

}
