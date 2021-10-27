package java.cn.mghio.leetcode.sort;

import java.util.Random;

/**
 * Given an array nums with n objects colored red, white, or blue, sort them in-place so that
 * objects of the same color are adjacent, with the colors in the order red, white, and blue.
 *
 * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
 *
 * You must solve this problem without using the library's sort function.
 *
 * @author mghio
 * @since 2021-10-27
 */
public class SortColors {

  /**
   * use insert sort threshold
   */
  private static final int INSERTION_SORT_THRESHOLD = 7;

  private static final Random RANDOM = new Random();

  /**
   * Given an array nums with n objects colored red, white, or blue, sort them in-place so that
   * objects of the same color are adjacent, with the colors in the order red, white, and blue.
   *
   * note: 0 - red, 1 - white, 2 - blue
   *
   * @param nums the array
   */
  public void sortColors(int[] nums) {
    if (nums == null || nums.length < 2) {
      return;
    }

    quickSort(nums, 0, nums.length - 1);
  }

  private void quickSort(int[] nums, int left, int right) {
    // use insert sort in small range
    if (right - left < INSERTION_SORT_THRESHOLD) {
      insertSort(nums, left, right);
      return;
    }

    // use quick sort in big range
    int pIndex = partition(nums, left, right);
    quickSort(nums, left, pIndex - 1);
    quickSort(nums, pIndex + 1, right);
  }

  private int partition(int[] nums, int left, int right) {
    int randomIndex = RANDOM.nextInt(right - left + 1) + left;
    swap(nums, left, randomIndex);

    int pivot = nums[left];
    int lt = left;
    for (int i = left + 1; i <= right; i++) {
      if (nums[i] < pivot) {
        lt++;
        swap(nums, i, lt);
      }
    }
    swap(nums, left, lt);
    return lt;
  }

  private void insertSort(int[] nums, int left, int right) {
    for (int i = left + 1; i <= right; i++) {
      int tmp = nums[i];
      int j = i;
      while (j > left && nums[j - 1] > tmp) {
        nums[j] = nums[j - 1];
        j--;
      }
      nums[j] = tmp;
    }
  }

  private void swap(int[] nums, int src, int dest) {
    int tmp = nums[src];
    nums[src] = nums[dest];
    nums[dest] = tmp;
  }

}
