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

  private final int[] original;

  public ShuffleArray(int[] nums) {
    this.nums = nums;
    this.original = new int[nums.length];
    System.arraycopy(nums, 0, original, 0, nums.length);
  }

  public int[] reset() {
    System.arraycopy(original, 0, nums, 0, nums.length);
    return nums;
  }

  public int[] shuffle() {
    for (int i = 0, len = nums.length; i < len; i++) {
      int next = i + new Random().nextInt(len - i);
      int temp = nums[i];
      nums[i] = nums[next];
      nums[next] = temp;
    }
    return nums;
  }

}
