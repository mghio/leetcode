package cn.mghio.leetcode.array;

/**
 * Single Number III.
 *
 * @author mghio
 * @since 2022-04-10
 */
public class SingleNumberIII {

  public int[] singleNumber(int[] nums) {
    if (nums == null || nums.length == 0) {
      return new int[]{};
    }

    int xorResult = 0;
    for (int num : nums) {
      xorResult ^= num;
    }

    int a = 0;
    int b = 0;
    int lsb = xorResult == Integer.MAX_VALUE ? xorResult : xorResult & (-xorResult);
    for (int num : nums) {
      if ((num & lsb) != 0) {
        a ^= num;
      } else {
        b ^= num;
      }
    }
    return new int[]{a, b};
  }

}
