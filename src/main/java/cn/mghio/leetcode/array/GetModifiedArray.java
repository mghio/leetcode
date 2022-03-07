package cn.mghio.leetcode.array;

/**
 * Assume you have an array of length n initialized with all 0's and are given k update operations.
 *
 * Each operation is represented as a triplet: [startIndex, endIndex, inc] which increments each
 * element of subarray A[startIndex ... endIndex] (startIndex and endIndex inclusive) with inc.
 *
 * Return the modified array after all k operations were executed.
 *
 * @author mghio
 * @since 2022-03-07
 */
public class GetModifiedArray {

  /**
   * Return the modified array after all k operations were executed.
   *
   * @param length the length
   * @param updates a triplet: [startIndex, endIndex, inc] which increments each element of subarray
   * A[startIndex ... endIndex] (startIndex and endIndex inclusive) with inc
   * @return the modified array after all k operations were executed
   */
  public int[] getModifiedArray(int length, int[][] updates) {
    if (updates == null || updates.length == 0 || updates[0].length == 0) {
      return new int[]{};
    }

    int[] diff = new int[length];
    for (int[] update : updates) {
      int startIndex = update[0];
      int endIndex = update[1];
      int incrVal = update[2];
      diff[startIndex] += incrVal;
      if (endIndex + 1 < length) {
        diff[endIndex + 1] -= incrVal;
      }
    }

    int[] res = new int[length];
    res[0] = diff[0];
    for (int i = 1; i < diff.length; i++) {
      res[i] = res[i - 1] + diff[i];
    }

    return res;
  }

}
