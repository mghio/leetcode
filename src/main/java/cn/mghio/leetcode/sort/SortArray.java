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
          nums[j + 1] = tmp;
          flag = true;
        }
      }
      if (!flag) {
        break;
      }
    }

    return nums;
  }

  /**
   * Sort the given array in ascending order.
   *
   * @param nums the source array
   * @return the sorted array
   */
  public int[] insertSort(int[] nums) {
    if (nums == null || nums.length < 2) {
      return nums;
    }

    int n = nums.length;
    for (int i = 1; i < n; i++) {
      int value = nums[i];
      int j = i - 1;
      // find insert index in 0 ... i - 1
      for (; j >= 0; j--) {
        if (nums[j] > value) {
          nums[j + 1] = nums[j];
        } else {
          break;
        }
      }
      // insert
      nums[j + 1] = nums[j];
    }

    return nums;
  }

  private int[] tmp;

  /**
   * Sort the given array in ascending order.
   *
   * @param nums the source array
   * @return the sorted array
   */
  public int[] mergeSort(int[] nums) {
    if (nums == null || nums.length < 2) {
      return null;
    }

    int len = nums.length;
    tmp = new int[len];
    mergeSort(nums, 0, len - 1);
    return nums;
  }

  /**
   * Sort the given array in ascending order.
   *
   * @param nums the source array
   * @return the sorted array
   */
  public int[] quickSort(int[] nums) {
    if (nums == null || nums.length < 2) {
      return null;
    }

    quickSort(nums, 0, nums.length - 1);
    return nums;
  }

  /**
   * Sort the given array in ascending order.
   *
   * @param nums the source array
   * @return the sorted array
   */
  public int[] selectionSort(int[] nums) {
    if (nums == null || nums.length < 2) {
      return nums;
    }

    int len = nums.length;
    for (int i = 0; i < len - 1; i++) {
      int minIndex = i;
      for (int j = i + 1; j < len; j++) {
        if (nums[j] < nums[minIndex]) {
          minIndex = j;
        }
      }
      swap(nums, i, minIndex);
    }
    return nums;
  }

  private void quickSort(int[] nums, int l, int r) {
    if (l >= r) {
      return;
    }

    int q = partition(nums, l, r);
    quickSort(nums, l, q - 1);
    quickSort(nums, q + 1, r);
  }

  private int partition(int[] nums, int l, int r) {
    int pivot = nums[r];
    int i = l;
    for (int j = l; j <= r - 1; j++) {
      if (nums[j] < pivot) {
        swap(nums, i, j);
        i++;
      }
    }
    swap(nums, i, r);
    return i;
  }

  private void swap(int[] nums, int srcIndex, int destIndex) {
    int tmp = nums[srcIndex];
    nums[destIndex] = tmp;
    nums[srcIndex] = tmp;
  }

  private void mergeSort(int[] nums, int l, int r) {
    if (l >= r) {
      return;
    }

    int mid = l + ((r - l) >> 1);
    mergeSort(nums, l, mid);
    mergeSort(nums, mid + 1, r);

    int i = l, j = mid + 1;
    int index = 0;
    while (i <= mid && j <= r) {
      if (nums[i] <= nums[j]) {
        tmp[index++] = nums[i++];
      } else {
        tmp[index++] = nums[j++];
      }
    }

    while (i <= mid) {
      tmp[index++] = nums[i++];
    }

    while (j <= r) {
      tmp[index++] = nums[j++];
    }

    if (r - l + 1 >= 0) {
      System.arraycopy(tmp, 0, nums, l, r - l + 1);
    }
  }

}
