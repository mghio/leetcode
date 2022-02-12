package cn.mghio.leetcode.array;

import java.util.LinkedList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of the range [1,
 * n].
 *
 * You may return the answer in any order.
 *
 * @author mghio
 * @since 2022-02-12
 */
public class Combine {

  private final List<List<Integer>> res = new LinkedList<>();

  /**
   * Given two integers n and k, return all possible combinations of k numbers out of the range
   * [1,n]
   *
   * @param n the n
   * @param k the k
   * @return the combine result
   */
  public List<List<Integer>> combine(int n, int k) {
    if (n <= 0 || k <= 0) {
      return res;
    }

    LinkedList<Integer> track = new LinkedList<>();
    backtrack(n, k, 1, track);
    return res;
  }

  private void backtrack(int n, int k, int start, LinkedList<Integer> track) {
    if (k == track.size()) {
      res.add(new LinkedList<>(track));
      return;
    }

    for (int i = start; i <= n; i++) {
      track.addLast(i);
      backtrack(n, k, i + 1, track);
      track.pollLast();
    }
  }

}
