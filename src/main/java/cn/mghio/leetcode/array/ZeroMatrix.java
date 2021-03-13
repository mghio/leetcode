package cn.mghio.leetcode.array;

/**
 * Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column are
 * set to 0.
 *
 * @author mghio
 * @since 2021-03-13
 */
public class ZeroMatrix {

  /**
   * 解法二：使用第一行和第一列标记
   *
   * 先记录第一行第一列是否有 0，然后利用第一行第一列作为标记，先清除非第一行或非第一列的数据， 最后根据第一列第一列是否有 0 来清除第一行第一列。
   *
   * @param matrix 源矩阵数组（二维数组）
   */
  public void solution2(int[][] matrix) {
    if (matrix == null || matrix.length == 0) {
      return;
    }

    boolean isFirstRowHasZero = false;
    boolean isFirstColHasZero = false;

    // 第一行是否有 0
    for (int[] ints : matrix) {
      if (ints[0] == 0) {
        isFirstRowHasZero = true;
        break;
      }
    }

    // 第一列是否有 0
    for (int i = 0; i < matrix[0].length; i++) {
      if (matrix[0][i] == 0) {
        isFirstColHasZero = true;
        break;
      }
    }

    // 清除非第一行或非第一列的数据
    for (int i = 1; i < matrix.length; i++) {
      for (int j = 1; j < matrix[i].length; j++) {
        if (matrix[i][j] == 0) {
          matrix[0][j] = 0;
          matrix[i][0] = 0;
        }
      }
    }
    for (int i = 1; i < matrix.length; i++) {
      for (int j = 1; j < matrix[i].length; j++) {
        if (matrix[0][j] == 0 || matrix[i][0] == 0) {
          matrix[i][j] = 0;
        }
      }
    }

    // 最后根据第一列第一列是否有 0 来清除第一行第一列
    for (int i = 0; i < matrix.length; i++) {
      if (isFirstRowHasZero) {
        matrix[i][0] = 0;
      }
    }
    for (int j = 0; j < matrix[0].length; j++) {
      if (isFirstColHasZero) {
        matrix[0][j] = 0;
      }
    }
  }

  /**
   * 解法一：分两步，先标记 0 在的行和列；然后再清 0
   *
   * @param matrix 源矩阵数组（二维数组）
   */
  public void solution1(int[][] matrix) {
    if (matrix == null || matrix.length == 0) {
      return;
    }

    boolean[] zeroOfRow = new boolean[matrix.length];
    boolean[] zeroOfColumn = new boolean[matrix[0].length];

    // 1. mark zero number of row and column.
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        if (matrix[i][j] == 0) {
          zeroOfRow[i] = true;
          zeroOfColumn[j] = true;
        }
      }
    }

    // 2. set the zero of row and column to 0.
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (zeroOfRow[i] || zeroOfColumn[j]) {
          matrix[i][j] = 0;
        }
      }
    }
  }

}
