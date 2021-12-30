package cn.mghio.leetcode.tree;

/**
 * Given an integer n, return the number of structurally unique BST's (binary search trees) which
 * has exactly n nodes of unique values from 1 to n.
 *
 * @author mghio
 * @since 2021-12-30
 */
public class NumTrees {

  /**
   * Given an integer n, return the number of structurally unique BST's (binary search trees) which
   * has exactly n nodes of unique values from 1 to n.
   *
   * @param n the n
   * @return the number of unique BST
   */
  public int numTreesSolution1(int n) {
    return count(1, n);
  }

  private int[] memo;

  /**
   * Given an integer n, return the number of structurally unique BST's (binary search trees) which
   * has exactly n nodes of unique values from 1 to n.
   *
   * @param n the n
   * @return the number of unique BST
   */
  public int numTreesSolution2(int n) {
    memo = new int[n + 1];
    return count(1, n);
  }

  private int count(int l, int h) {
    if (l > h) {
      return 1;
    }

    if (memo[h - l] != 0) {
      return memo[h - l];
    }

    int res = 0;
    for (int i = l; i <= h; i++) {
      int left = count(l, i - 1);
      int right = count(i + 1, h);
      res += left * right;
    }

    memo[h - l] = res;

    return res;
  }

}
