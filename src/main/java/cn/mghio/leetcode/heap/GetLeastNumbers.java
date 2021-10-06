package java.cn.mghio.leetcode.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Enter the integer array arr and find the smallest k numbers.
 *
 * @author mghio
 * @since 2021-10-06
 */
public class GetLeastNumbers {

  /**
   * Find the smallest k numbers.
   *
   * @param arr the array
   * @param k the k number
   * @return the smallest k numbers
   */
  public int[] getLeastNumbersUseBuildInSort(int[] arr, int k) {
    int[] ret = new int[k];
    if (k == 0) {
      return ret;
    }

    Arrays.sort(arr);
    System.arraycopy(arr, 0, ret, 0, k);
    return ret;
  }

  /**
   * Find the smallest k numbers.
   *
   * @param arr the array
   * @param k the k number
   * @return the smallest k numbers
   */
  public int[] getLeastNumbersUseMaxHeap(int[] arr, int k) {
    int[] ret = new int[k];
    if (k == 0) {
      return ret;
    }

    // max heap
    PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
    for (int i = 0; i < k; i++) {
      queue.offer(arr[i]);
    }

    for (int i = k; i < arr.length; i++) {
      if (queue.peek() > arr[i]) {
        queue.poll();
        queue.offer(arr[i]);
      }
    }

    for (int i = 0; i < k; i++) {
      ret[i] = queue.poll();
    }

    return ret;
  }

}
