package cn.mghio.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Input a positive integer target, and output all consecutive positive integer sequences
 * (containing at least two numbers) whose sum is target.
 *
 * The numbers in the sequence are arranged from small to large, and different sequences are
 * arranged from small to large according to the first number.
 *
 * @author mghio
 * @since 2021-10-25
 */
public class FindContinuousSequence {

  /**
   * Find all consecutive positive integer sequences.
   *
   * @param target the target
   * @return the continuous sequence
   */
  public int[][] findContinuousSequence(int target) {
    if (target < 3) {
      return new int[0][0];
    }

    List<int[]> ans = new ArrayList<>();
    for (int l = 1, r = 2; l < r;) {
      int sum = (l + r) * (r - l + 1) / 2;
      if (sum == target) {
        int[] res = new int[r - l + 1];
        for (int i = l; i <= r; i++) {
          res[i - l] = i;
        }
        ans.add(res);
        l++;
      } else if (sum < target) {
        r++;
      } else {
        l++;
      }
    }

    return ans.toArray(new int[ans.size()][]);
  }

}
