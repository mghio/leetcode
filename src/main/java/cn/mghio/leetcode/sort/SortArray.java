package java.cn.mghio.leetcode.sort;

/**
 * Given an array of integers nums, sort the array in ascending order.
 *
 * @author mghio
 * @since 2021-10-18
 */
public class SortArray {

  /**
   * Sort the given array in ascending order.
   *
   * @param nums the source array
   * @return the sorted array
   */
  public int[] bubbleSort(int[] nums) {
    if (nums == null || nums.length < 2) {
      return nums;
    }

    int n = nums.length;
    for (int i = n - 1; i > 0; i--) {
      // has element exchange
      boolean flag = false;
      for (int j = 0; j < i; j++) {
        if (nums[j] < nums[j + 1]) {
          int tmp = nums[j];
          nums[j] = nums[j + 1];
          nums[j  +1] = tmp;
          flag = true;
        }
      }
      if (!flag) {
        break;
      }
    }

    return nums;
  }

}
