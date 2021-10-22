package java.cn.mghio.leetcode.array;

/**
 * In the two numbers in the array, if the first number is greater than the following number, the
 * two numbers form a reverse pair. Enter an array and find the total number of reverse pairs in
 * this array.
 *
 * @author mghio
 * @since 2021-10-22
 */
public class ReversePairs {

  /**
   * Given an array and find the total number of reverse pairs in this array.
   *
   * NOTE: time out.
   *
   * @param nums the array
   * @return the total number of reverse pairs
   */
  public int reversePairsSolution1(int[] nums) {
    if (nums == null) {
      return 0;
    }

    int number = 0;
    int len = nums.length;
    for (int i = 0; i < len; i++) {
      for (int j = i + 1; j < len; j++) {
        if (nums[i] > nums[j]) {
          number++;
        }
      }
    }
    return number;
  }

}
