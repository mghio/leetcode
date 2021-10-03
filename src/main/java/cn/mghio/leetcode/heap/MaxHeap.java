package java.cn.mghio.leetcode.heap;

/**
 * The heap data struct.
 *
 * @author mghio
 * @since 2021-10-03
 */
public class MaxHeap {

  /**
   * Store data starting from index 1
   */
  private final int[] a;

  /**
   * The maximum number of data that the heap can store
   */
  private final int n;

  /**
   * The number of data stored in the heap
   */
  private int count;

  public MaxHeap(int capacity) {
    a = new int[capacity + 1];
    n = capacity;
    count = 0;
  }

  public void buildMaxHeap(int[] a, int n) {
    for (int i = n / 2; i >= 1; --i) {
      heapify(a, n, i);
    }
  }

  public void sort(int[] a, int n) {
    buildMaxHeap(a, n);
    int k = n;
    while (k > 1) {
      swap(a, 1, k);
      --k;
      heapify(a, k, 1);
    }
  }

  /**
   * insert data to the heap
   *
   * @param data the data value
   */
  public void insert(int data) {
    if (count > n) {
      // heap is full
      return;
    }

    a[++count] = data;
    int i = count;
    while (a[i] > a[(i - 1) / 2]) {
      // Bottom-up heapify
      swap(a, i, (i - 1) / 2);
      i = (i - 1) / 2;
    }
  }

  /**
   * remove the max data (top element) from the max heap.
   */
  public void removeMax() {
    if (count == 0) {
      return;
    }

    a[1] = a[count--];
    heapify(a, count, 1);
  }

  /**
   * Up-down heapify.
   *
   * @param a the number array
   * @param n the heap size
   * @param i the data index in array
   */
  private void heapify(int[] a, int n, int i) {
    while (true) {
      int l = i * 2 + 1;
      int r = i * 2 + 2;
      int maxPos = i;

      if (l < n && a[i] < a[l]) {
        maxPos = l;
      }
      if (r < n && a[maxPos] < a[r]) {
        maxPos = r;
      }
      if (maxPos == i) {
        // already iteration leaf node index in the array
        break;
      }

      swap(a, i, maxPos);
      i = maxPos;
    }
  }

  private void swap(int[] a, int sourceIndex, int targetIndex) {
    int tmp = a[sourceIndex];
    a[sourceIndex] = targetIndex;
    a[targetIndex] = tmp;
  }
}
