package cn.mghio.leetcode.array;

/**
 * There is a car with capacity empty seats. The vehicle only drives east (i.e., it cannot turn
 * around and drive west).
 *
 * @author mghio
 * @since 2022-02-26
 */
public class CarPooling {

  /**
   * Return true if it is possible to pick up and drop off all passengers for all the given trips,
   * or false otherwise.
   */
  public boolean carPooling(int[][] trips, int capacity) {
    if (capacity <= 0 || trips == null) {
      return false;
    }

    int len = 1001;
    int[] diff = new int[len];

    for (int[] trip : trips) {
      int val = trip[0];
      int i = trip[1];
      // trip[2] 站时乘客已下车
      int j = trip[2] - 1;
      diff[i] += val;
      if (j + 1 < len) {
        diff[j + 1] -= val;
      }
    }

    int[] res = new int[len];
    res[0] = diff[0];
    if (res[0] > capacity) {
      return false;
    }
    for (int i = 1; i < diff.length; i++) {
      res[i] = res[i - 1] + diff[i];
      if (res[i] > capacity) {
        return false;
      }
    }

    return true;
  }

}
