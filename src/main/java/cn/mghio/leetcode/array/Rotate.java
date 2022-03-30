package cn.mghio.leetcode.array;

/**
 * Rotate Image.
 *
 * @author mghio
 * @since 2022-03-30
 */
public class Rotate {

  public void rotate(int[][] matrix) {
    if (matrix == null || matrix.length == 0) {
      return;
    }

    int len = matrix.length;
    // horizontal flip
    for (int i = 0; i < len / 2; i++) {
      for (int j = 0; j < len; j++) {
        int tmp = matrix[i][j];
        matrix[i][j] = matrix[len - i - 1][j];
        matrix[len - i - 1][j] = tmp;
      }
    }

    // main diagonal flip
    for (int i = 0; i < len; i++) {
      for (int j = 0; j < i; j++) {
        int tmp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = tmp;
      }
    }
  }

}
