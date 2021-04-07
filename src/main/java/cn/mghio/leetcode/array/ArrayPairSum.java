package cn.mghio.leetcode.array;

import java.util.Arrays;

/**
 * 给定长度为 2n 的整数数组 nums ，你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ， 使得从 1 到 n 的 min(ai,
 * bi) 总和最大。返回该最大总和 。
 *
 * @author mghio
 * @since 2021-04-07
 */
public class ArrayPairSum {

  public int arrayPairSum(int[] nums) {
    if (nums == null || nums.length % 2 != 0) {
      return 0;
    }

    // 思路：将两个最大的数排在一组则结果必然包含第二最大值, 同理去除最大值和第二最大值后,
    // 将剩下值中最大值和第二最大值排在一组... 逐步最优 —————> 全局最优
    int result = 0;
    Arrays.sort(nums);
    for (int i = 0, len = nums.length; i < len; i++) {
      if (i % 2 == 0) {
        result += nums[i];
      }
    }
    return result;
  }

}
