package cn.mghio.leetcode.array;

/**
 * Given an image represented by an N x N matrix, where each pixel in the image is 4 bytes, write a
 * method to rotate the image by 90 degrees. Can you do this in place?
 *
 * @author mghio
 * @since 2021-03-03
 */
public class MatrixRotate {

  public void rotateSolution1(int[][] matrix) {
    if (matrix == null || matrix.length == 1) {
      return;
    }

    int len = matrix.length;
    int maxIdx = matrix.length - 1;
    int[][] newMatrix = new int[len][len];
    for (int i = 0; i < len; i++) {
      for (int j = 0; j < len; j++) {
        newMatrix[j][maxIdx - i] = matrix[i][j];
      }
    }
    for (int i = 0; i < len; i++) {
      System.arraycopy(newMatrix[i], 0, matrix[i], 0, len);
    }
  }

}
