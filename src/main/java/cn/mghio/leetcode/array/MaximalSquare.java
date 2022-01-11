package cn.mghio.leetcode.array;

/**
 * Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's
 * and return its area.
 *
 * @author mghio
 * @since 2022-01-11
 */
public class MaximalSquare {

  /**
   * Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's
   * and return its area.
   *
   * @param matrix the array
   * @return the result
   */
  public int maximalSquareSolution1(char[][] matrix) {
    int maxSide = 0;
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return 0;
    }

    int rowLen = matrix.length;
    int colLen = matrix[0].length;
    for (int i = 0; i < rowLen; i++) {
      for (int j = 0; j < colLen; j++) {
        if (matrix[i][j] == '1') {
          maxSide = Math.max(maxSide, 1);
          int curMaxSide = Math.min(rowLen - i, colLen - j);
          for (int k = 1; k < curMaxSide; k++) {
            boolean flag = true;
            if (matrix[i + k][j + k] == '0') {
              break;
            }
            for (int l = 0; l < k; l++) {
              if (matrix[i + k][j + l] == '0' || matrix[i + l][j + k] == '0') {
                flag = false;
                break;
              }
            }
            if (flag) {
              maxSide = Math.max(maxSide, k + 1);
            } else {
              break;
            }
          }
        }
      }
    }

    return maxSide * maxSide;
  }

}
