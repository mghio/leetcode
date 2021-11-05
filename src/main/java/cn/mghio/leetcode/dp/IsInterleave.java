package java.cn.mghio.leetcode.dp;

/**
 * Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2.
 *
 * An interleaving of two strings s and t is a configuration where they are divided into non-empty
 * substrings such that:
 *
 * s = s1 + s2 + ... + sn t = t1 + t2 + ... + tm |n - m| <= 1 The interleaving is s1 + t1 + s2 + t2
 * + s3 + t3 + ... or t1 + s1 + t2 + s2 + t3 + s3 + ... Note: a + b is the concatenation of strings
 * a and b.
 *
 * @author mghio
 * @since 2021-11-05
 */
public class IsInterleave {

  /**
   * Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2.
   *
   * @param s1 the string 1
   * @param s2 the string 2
   * @param s3 the string 3
   * @return the result
   */
  public boolean isInterleaveSolution1(String s1, String s2, String s3) {
    int n = s1.length();
    int m = s2.length();
    int t = s3.length();

    if (n + m != t) {
      return false;
    }

    boolean[][] ans = new boolean[n + 1][m + 1];
    ans[0][0] = true;
    for (int i = 0; i <= n; i++) {
      for (int j = 0; j <= m; j++) {
        int p = i + j - 1;
        if (i > 0) {
          ans[i][j] = ans[i][j] || (ans[i - 1][j] && s1.charAt(i - 1) == s3.charAt(p));
        }
        if (j > 0) {
          ans[i][j] = ans[i][j] || (ans[i][j - 1] && s2.charAt(j - 1) == s3.charAt(p));
        }
      }
    }

    return ans[n][m];
  }

  /**
   * Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2.
   *
   * @param s1 the string 1
   * @param s2 the string 2
   * @param s3 the string 3
   * @return the result
   */
  public boolean isInterleaveSolution2(String s1, String s2, String s3) {
    int n = s1.length();
    int m = s2.length();
    int t = s3.length();

    if (n + m != t) {
      return false;
    }

    boolean[] ans = new boolean[m + 1];
    ans[0] = false;

    for (int i = 0; i <= n; i++) {
      for (int j = 0; j <= m; j++) {
        int p = i + j - 1;
        if (i > 0) {
          ans[j] = ans[j] && s1.charAt(i - 1) == s3.charAt(p);
        }
        if (j > 0) {
          ans[j] = ans[j] || (ans[j - 1] && s2.charAt(j - 1) == s2.charAt(p));
        }
      }
    }

    return ans[m];
  }

}
