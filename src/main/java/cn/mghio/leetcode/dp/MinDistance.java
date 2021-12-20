package cn.mghio.leetcode.dp;

/**
 * Given two strings word1 and word2, return the minimum number of operations required to convert
 * word1 to word2.
 *
 * @author mghio
 * @since 2021-12-20
 */
public class MinDistance {

  private char[] a;
  private char[] b;
  private int m;
  private int n;
  private int minDist = Integer.MAX_VALUE;

  /**
   * Given two strings word1 and word2, return the minimum number of operations required to convert
   * word1 to word2.
   *
   * NOTE: time out!
   *
   * @param word1 the word1
   * @param word2 the word2
   * @return the min distance
   */
  public int minDistance(String word1, String word2) {
    if (word1 == null || word2 == null) {
      return 0;
    }
    if (word1.length() == 0 || word2.length() == 0) {
      return word1.length() == 0 ? word2.length() : word1.length();
    }

    a = word1.toCharArray();
    b = word2.toCharArray();
    m = word1.length();
    n = word2.length();

    lwsBT(0, 0, 0);

    return minDist;
  }

  private void lwsBT(int i, int j, int dist) {
    if (i == n || j == m) {
      if (i < n) {
        dist += n - i;
      }
      if (j < m) {
        dist += m - j;
      }
      if (dist < minDist) {
        minDist = dist;
      }
      return;
    }

    if (a[i] == b[j]) {
      lwsBT(i + 1, j + 1, dist);
    } else {
      lwsBT(i + 1, j, dist + 1);
      lwsBT(i, j + 1, dist + 1);
      lwsBT(i + 1, j + 1, dist + 1);
    }
  }

}
