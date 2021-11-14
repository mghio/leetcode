package cn.mghio.leetcode.heap;

/**
 * Given an integer array nums and an integer k, return the kth the largest element in the array.
 *
 * @author mghio
 * @since 2021-10-03
 */
public class FindKthLargest {

  /**
   * Find Kth largest.
   *
   * @param nums the number array
   * @param k the kth
   * @return the kth value
   */
  public int findKthLargest(int[] nums, int k) {
    int heapSize = nums.length;
    buildMapHeap(nums, heapSize);

    for (int i = nums.length - 1; i >= nums.length - k + 1; i--) {
      swap(nums, 0, i);
      --heapSize;
      maxHeapify(nums, 0, heapSize);
    }

    return nums[0];
  }

  private void buildMapHeap(int[] a, int heapSize) {
    for (int i = heapSize / 2; i >= 0; i--) {
      maxHeapify(a, i, heapSize);
    }
  }

  private void maxHeapify(int[] a, int i, int heapSize) {
    int l = i * 2 + 1;
    int r = i * 2 + 2;
    int largest = i;

    if (l < heapSize && a[l] > a[largest]) {
      largest = l;
    }
    if (r < heapSize && a[r] > a[largest]) {
      largest = r;
    }
    if (largest != i) {
      swap(a, i, largest);
      maxHeapify(a, largest, heapSize);
    }
  }

  private void swap(int[] a, int i, int j) {
    int tmp = a[i];
    a[i] = a[j];
    a[j] = tmp;
  }

}
