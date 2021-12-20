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

  /**
   * Given two strings word1 and word2, return the minimum number of operations required to convert
   * word1 to word2.
   *
   * @param word1 the word1
   * @param word2 the word2
   * @return the min distance
   */
  public int minDistanceSolution2(String word1, String word2) {
    if (word1 == null || word2 == null) {
      return 0;
    }
    if (word1.length() == 0 || word2.length() == 0) {
      return word1.length() == 0 ? word2.length() : word1.length();
    }

    return lwsDP(word1.toCharArray(), word1.length(), word2.toCharArray(), word2.length());
  }

  private int lwsDP(char[] a, int m, char[] b, int n) {
    int[][] minDist = new int[m][n];

    for (int i = 0; i < n; i++) {
      if (a[0] == b[i]) {
        minDist[0][i] = i;
      } else if (i != 0) {
        minDist[0][i] = minDist[0][i - 1] + 1;
      } else {
        minDist[0][i] = 1;
      }
    }

    for (int i = 0; i < m; i++) {
      if (a[i] == b[0]) {
        minDist[i][0] = i;
      } else if (i != 0) {
        minDist[i][0] = minDist[i - 1][0] + 1;
      } else {
        minDist[i][0] = 1;
      }
    }

    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        if (a[i] == b[j]) {
          minDist[i][j] = min(minDist[i - 1][j] + 1, minDist[i][j - 1] + 1, minDist[i - 1][j - 1]);
        } else {
          minDist[i][j] = min(minDist[i - 1][j] + 1, minDist[i][j - 1] + 1, minDist[i - 1][j - 1] + 1);
        }
      }
    }

    return minDist[m - 1][n - 1];
  }

  private int min(int item1, int item2, int item3) {
    return Math.min(Math.min(item1, item2), item3);
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
