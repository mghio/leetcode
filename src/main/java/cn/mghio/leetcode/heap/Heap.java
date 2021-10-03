package java.cn.mghio.leetcode.heap;

/**
 * The heap data struct.
 *
 * @author mghio
 * @since 2021-10-03
 */
public class Heap {

  /**
   * Store data starting from index 1
   */
  private int[] a;

  /**
   * The maximum number of data that the heap can store
   */
  private int n;

  /**
   * The number of data stored in the heap
   */
  private int count;

  public Heap(int capacity) {
    a = new int[capacity + 1];
    n = capacity;
    count = 0;
  }

  public void buildHeap(int[] a, int n) {
    for (int i = n / 2; i >= 1; --i) {
      heapify(a, n, i);
    }
  }

  public void sort(int[] a, int n) {
    buildHeap(a, n);
    int k = n;
    while (k > 1) {
      swap(a, 1, k);
      --k;
      heapify(a, k, 1);
    }
  }

  public void insert(int data) {
    if (count > n) {
      // heap is full
      return;
    }

    ++count;
    a[count] = data;
    int i = count;
    while (i / 2 > 0 && a[i] > a[i / 2]) {
      // Bottom-up heapify
      swap(a, i, i / 2);
      i = i / 2;
    }
  }

  public void removeMax() {
    if (count == 0) {
      return;
    }

    a[1] = a[count];
    --count;
    heapify(a, count, 1);
  }

  private void heapify(int[] a, int n, int i) {
    while (true) {
      int maxPos = i;
      if (i * 2 < n && a[i] < a[i * 2]) {
        maxPos = i * 2;
      }
      if (i * 2 + 1 < n && a[maxPos] < a[i * 2 + 1]) {
        maxPos = i * 2 + 1;
      }
      if (maxPos == i) {
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
