package java.cn.mghio.leetcode.dp;

/**
 * Give you a rope of length n, please cut the rope into m segments of integer length (m and n are
 * integers, n>1 and m>1), the length of each segment of rope is recorded as k[0],k [1]...k[m-1].
 * What is the maximum possible product of k[0]*k[1]*...*k[m-1]?
 *
 * For example, when the length of the rope is 8, we cut it into three pieces with lengths of 2, 3,
 * and 3. The maximum product obtained at this time is 18.
 *
 * @author mghio
 * @since 2021-10-09
 */
public class CuttingRope {

  /**
   * Cutting rope.
   *
   * @param n the rope length
   * @return the maximum possible
   */
  public int cuttingRopeInDp(int n) {
    if (n < 2) {
      return 0;
    }
    if (n == 2) {
      return 1;
    }
    if (n == 3) {
      return 2;
    }

    int[] products = new int[n + 1];
    products[0] = 0;
    products[1] = 1;
    products[2] = 2;
    products[3] = 3;
    int max;

    for (int i = 4; i < n; i++) {
      max = 0;
      for (int j = 1; j < i / 2; j++) {
        int product = products[j] * products[i - j];
        if (max < product) {
          max = product;
        }
        products[i] = max;
      }
    }

    max = products[n];
    return max;
  }

}
