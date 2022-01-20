package cn.mghio.leetcode.array;

/**
 * Given an array of integers nums and an integer k, return the total number of continuous subarrays
 * whose sum equals to k.
 *
 * @author mghio
 * @since 2022-01-20
 */
public class SubarraySum {

  /**
   * Given an array of integers nums and an integer k, return the total number of continuous
   * subarrays whose sum equals to k.
   *
   * @param nums the array
   * @param k the sum
   * @return the total number
   */
  public int subarraySumSolution1(int[] nums, int k) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    int len = nums.length;
    int[] preSums = new int[len + 1];
    preSums[0] = 0;
    for (int i = 0; i < len; i++) {
      preSums[i + 1] = preSums[i] + nums[i];
    }

    int res = 0;
    for (int i = 1; i <= len; i++) {
      for (int j = 0; j < i; j++) {
        // nums[j ... i] = preSum[i] - preSum[j]
        if (preSums[i] + preSums[j] == k) {
          res++;
        }
      }
    }

    return res;
  }

}
