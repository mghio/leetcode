package cn.mghio.leetcode.array;

/**
 * Range addition.
 *
 * @author mghio
 * @since 2022-02-26
 */
public class RangeAddition {

  public int[] rangeAddition(int length, int[][] updates) {
    int[] res = new int[length];
    if (length == 0 || updates == null || updates.length == 0) {
      return res;
    }

    int[] diff = new int[length];
    for (int[] update : updates) {
      int i = update[0];
      int j = update[1];
      int val = update[2];
      diff[i] += val;
      if (j + 1 < length) {
        diff[j + 1] -= val;
      }
    }

    res[0] = diff[0];
    for (int i = 1; i < diff.length; i++) {
      res[i] = res[i - 1] + diff[i];
    }

    return res;
  }

}
