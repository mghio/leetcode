package cn.mghio.leetcode.thinking;

/**
 * Given an array A[0,1,…,n-1], please construct an array B[0,1,…,n-1], where the value of B[i] is
 * in the array A except for the subscript i The product of the elements of
 * B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]. Division cannot be used.
 *
 * @author mghio
 * @since 2021-10-17
 */
public class ConstructArr {

  /**
   * Given an array A[0,1,…,n-1], then construct an array B[0,1,…,n-1], where the value of B[i] is
   * in the array A except for the subscript i The product of the elements of
   * B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1].
   *
   * @param a the a array
   * @return the constructed array
   */
  public int[] constructArr(int[] a) {
    if (a == null) {
      return null;
    }

    int len = a.length;
    if (len == 0) {
      return new int[0];
    }

    int[] b = new int[len];
    b[0] = 1;
    int tmp = 1;
    for (int i = 1; i < len; i++) {
      b[i] = b[i - 1] * a[i - 1];
    }

    for (int i = len - 2; i >= 0; i--) {
      tmp *= a[i + 1];
      b[i] *= tmp;
    }

    return b;
  }

}
