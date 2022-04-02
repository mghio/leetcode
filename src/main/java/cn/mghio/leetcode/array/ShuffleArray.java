package cn.mghio.leetcode.array;

import java.util.Random;

/**
 * Shuffle an Array.
 *
 * @author mghio
 * @since 2022-04-02
 */
public class ShuffleArray {

  private final int[] nums;

  private final Random random;

  private final int size;

  public ShuffleArray(int[] nums) {
    this.nums = nums;
    this.random = new Random();
    this.size = nums.length;
  }

  public int[] reset() {
    return nums;
  }

  public int[] shuffle() {
    int[] rets = nums.clone();
    for (int i = 0; i < size; i++) {
      swap(rets, i, i + random.nextInt(size - i));
    }
    return rets;
  }

  private void swap(int[] rets, int i, int j) {
    int temp = rets[i];
    rets[i] = rets[j];
    rets[j] = temp;
  }

}
