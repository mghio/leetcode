package cn.mghio.leetcode.heap;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * Enter the integer array arr and find the smallest k numbers.
 *
 * @author mghio
 * @since 2021-10-06
 */
public class GetLeastNumbers {

  /*-------------------------------------- Solutions One -------------------------------------*/

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

  /*-------------------------------------- Solutions Two -------------------------------------*/

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

  /*-------------------------------------- Solutions Three -------------------------------------*/

  /**
   * Find the smallest k numbers.
   *
   * @param arr the array
   * @param k the k number
   * @return the smallest k numbers
   */
  public int[] getLeastNumbersUsePartition(int[] arr, int k) {
    randomizedSelected(arr, 0, arr.length - 1, k);
    int[] ret = new int[k];
    System.arraycopy(arr, 0, ret, 0, k);
    return ret;
  }

  private void randomizedSelected(int[] arr, int l, int r, int k) {
    if (l >= r) {
      return;
    }

    int pos = randomizedPartition(arr, l, r);
    int num = pos - l + 1;
    if (k == num) {
      return;
    } else if (k < num) {
      randomizedSelected(arr, l, pos - 1, k);
    } else {
      randomizedSelected(arr, pos + 1, r, k - num);
    }
  }

  private int randomizedPartition(int[] arr, int l, int r) {
    int i = new Random().nextInt(r - l + 1) + l;
    swap(arr, r, i);
    return partition(arr, l, r);
  }

  private int partition(int[] arr, int l, int r) {
    int pivot = arr[r];
    int i = l - 1;
    for (int j = l; j <= r - 1; j++) {
      if (arr[j] <= pivot) {
        i = i + 1;
        swap(arr, i, j);
      }
    }
    swap(arr, i + 1, r);
    return i + 1;
  }

  private void swap(int[] arr, int r, int i) {
    int tmp = arr[r];
    arr[r] = arr[i];
    arr[i] = tmp;
  }

}
