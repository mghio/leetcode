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

  /**
   * Given an array and find the total number of reverse pairs in this array.
   *
   * @param nums the array
   * @return the total number of reverse pairs
   */
  public int reversePairsSolution2(int[] nums) {
    if (nums == null) {
      return 0;
    }

    int len = nums.length;
    if (len < 2) {
      return 0;
    }

    int[] copy = new int[len];
    System.arraycopy(nums, 0, copy, 0, len);

    int[] temp = new int[len];
    return reversePairs(copy, 0, len - 1, temp);
  }

  private int reversePairs(int[] nums, int left, int right, int[] temp) {
    if (left == right) {
      return 0;
    }

    int mid = left + (right - left) / 2;
    int leftPairs = reversePairs(nums, left, mid, temp);
    int rightPairs = reversePairs(nums, mid + 1, right, temp);

    if (nums[mid] <= nums[mid + 1]) {
      return leftPairs + rightPairs;
    }

    int crossPairs = mergeAndCount(nums, left, mid, right, temp);
    return leftPairs + rightPairs + crossPairs;
  }

  private int mergeAndCount(int[] nums, int left, int mid, int right, int[] temp) {
    if (right + 1 - left >= 0) {
      System.arraycopy(nums, left, temp, left, right + 1 - left);
    }

    int i = left;
    int j = mid + 1;

    int count = 0;
    for (int k = left; k <= right; k++) {

      if (i == mid + 1) {
        nums[k] = temp[j];
        j++;
      } else if (j == right + 1) {
        nums[k] = temp[i];
        i++;
      } else if (temp[i] <= temp[j]) {
        nums[k] = temp[i];
        i++;
      } else {
        nums[k] = temp[j];
        j++;
        count += (mid - i + 1);
      }
    }
    return count;
  }

}
