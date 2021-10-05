package java.cn.mghio.leetcode.heap;

/**
 * The heap data struct.
 *
 * @author mghio
 * @since 2021-10-04
 */
public class MinHeap {

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

  public MinHeap(int capacity) {
    this.a = new int[capacity];
    this.n = capacity;
    this.count = 0;
  }

  public void buildMinHeap(int[] a, int n) {
    for (int i = n / 2; i >= 1; i--) {
      heapify(a, n, i);
    }
  }

  public void insert(int data) {
    if (count > n) {
      // heap is full
      return;
    }

    a[++count] = data;
    int i = count;
    while (a[i] < a[i / 2]) {
      swap(a, i, i / 2);
      i = i / 2;
    }
  }

  public int removeMin() {
    if (count == 0) {
      return 0;
    }

    int ret = a[count];
    a[1] = a[count--];
    heapify(a, count, 0);

    return ret;
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
      int l = i * 2;
      int r = i * 2 + 1;
      int minPos = i;

      if (l <= n && a[i] > a[l]) {
        minPos = l;
      }
      if (r <= n && a[minPos] > a[r]) {
        minPos = r;
      }
      if (minPos == i) {
        break;
      }

      swap(a, i, minPos);
      i = minPos;
    }

  }

  private void swap(int[] a, int sourceIndex, int targetIndex) {
    int tmp = a[sourceIndex];
    a[sourceIndex] = targetIndex;
    a[targetIndex] = tmp;
  }
}
