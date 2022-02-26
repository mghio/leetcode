package cn.mghio.leetcode.array;

/**
 * Prefix sum array.
 *
 * @author mghio
 * @since 2022-02-26
 */
public class PrefixSum {

  private final int[] prefix;

  public PrefixSum(int[] nums) {
    prefix = new int[nums.length + 1];
    for (int i = 1; i < nums.length; i++) {
      prefix[i] = prefix[i - 1] + nums[i - 1];
    }
  }

  /**
   * Query the cumulative sum of the closed interval [i, j].
   *
   * @param i the start index
   * @param j the end index
   * @return the sum of the closed interval i and j
   */
  public int query(int i, int j) {
    return prefix[i + 1] - prefix[j];
  }
}
