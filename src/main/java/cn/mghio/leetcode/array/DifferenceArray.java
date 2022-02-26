package cn.mghio.leetcode.array;

/**
 * Difference array.
 *
 * @author mghio
 * @since 2022-02-26
 */
public class DifferenceArray {

  private final int[] diff;

  public DifferenceArray(int[] nums) {
    diff = new int[nums.length];
    diff[0] = nums[0];
    for (int i = 1; i < nums.length; i++) {
      diff[i] = nums[i] - nums[i - 1];
    }
  }

  public int[] getSourceArray() {
    int[] source = new int[diff.length];
    source[0] = diff[0];
    for (int i = 1; i < diff.length; i++) {
      source[i] = source[i - 1] + diff[i];
    }
    return source;
  }

  public void increment(int i, int j, int val) {
    diff[i] += val;
    if (j + 1 < diff.length) {
      diff[j + 1] -= val;
    }
  }
}
