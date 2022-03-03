package cn.mghio.leetcode.binary;

/**
 * All but two numbers in an integer array nums appear twice. Please write a program to find these
 * two numbers that occur only once. The time complexity is required to be O(n) and the space
 * complexity is O(1).
 *
 * @author mghio
 * @since 2022-03-03
 */
public class SingleNumbers {

  public int[] singleNumbers(int[] nums) {
    if (nums == null || nums.length < 2) {
      return null;
    }

    int res = 0;
    for (int num : nums) {
      res ^= num;
    }

    int div = 1;
    while ((div & res) != 0) {
      div <<= 1;
    }

    int a = 0;
    int b = 0;
    for (int num : nums) {
      if ((num & div) != 0) {
        a ^= num;
        continue;
      }
      b ^= num;
    }

    return new int[]{a, b};
  }

}
