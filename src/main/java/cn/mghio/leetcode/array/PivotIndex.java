package cn.mghio.leetcode.array;

/**
 * Given an array of integers nums, calculate the pivot index of this array.
 *
 * The pivot index is the index where the sum of all the numbers strictly to the left of the index
 * is equal to the sum of all the numbers strictly to the index's right. If the index is on the left
 * edge of the array, then the left sum is 0 because there are no elements to the left. This also
 * applies to the right edge of the array. Return the leftmost pivot index. If no such index exists,
 * return -1.
 *
 * @author mghio
 * @since 2021-03-02
 */
public class PivotIndex {

  public int pivotIndex(int[] nums) {
    if (nums == null || nums.length == 0 || nums.length == 1 || nums.length == 2) {
      return -1;
    }

    int leftSum = 0;
    int rightSum = 0;
    for (int i = 1; i < nums.length; i++) {
      rightSum += nums[i];
    }
    if (leftSum == rightSum) {
      return 0;
    }
    for (int i = 1; i < nums.length; i++) {
      rightSum -= nums[i];
      leftSum += nums[i - 1];
      if (leftSum == rightSum) {
        return i;
      }
    }
    return -1;
  }

}
