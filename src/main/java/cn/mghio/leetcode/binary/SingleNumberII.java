package cn.mghio.leetcode.binary;

/**
 * All numbers in an array nums appear three times, except for one number that appears only once.
 * Please find the number that occurs only once.
 *
 * @author mghio
 * @since 2022-03-03
 */
public class SingleNumberII {

  public int singleNumber(int[] nums) {
    if (nums == null || nums.length == 0) {
      throw new IllegalArgumentException("Invalid input.");
    }

    int[] biSum = new int[32];
    biSum[0] = 0;
    for (int num : nums) {
      int bitMask = 1;
      for (int j = 31; j >= 0; j--) {
        int bit = num & bitMask;
        if (bit != 0) {
          biSum[j] += 1;
        }
        bitMask <<= 1;
      }
    }

    int ret = 0;
    for (int i = 0; i < 32; i++) {
      ret <<= 1;
      ret += biSum[i] % 3;
    }
    return ret;
  }

}
