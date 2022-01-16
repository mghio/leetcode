package cn.mghio.leetcode.array;

/**
 * In an n*m 2D array, each row is sorted in increasing order from left to right, and each column is
 * sorted in increasing order from top to bottom. Please complete an efficient function, input such
 * a two-dimensional array and an integer, and determine whether the array contains the integer.
 *
 * @author mghio
 * @since 2022-01-16
 */
public class FindNumberIn2DArray {

  /**
   * input such a two-dimensional array and an integer, and determine whether the array contains the
   * integer.
   *
   * @param matrix the 2-D array
   * @param target the target value
   * @return whether the array contains the integer
   */
  public boolean findNumberIn2DArray(int[][] matrix, int target) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return false;
    }

    boolean res = false;
    int rows = matrix.length, cols = matrix[0].length;
    int curRow = 0, curCol = cols - 1;
    while (curRow < rows && curCol >= 0) {
      int val = matrix[curRow][curCol];
      if (val == target) {
        res = true;
        break;
      } else if (val > target) {
        curCol--;
      } else {
        curRow++;
      }
    }

    return res;
  }

  /**
   * input such a two-dimensional array and an integer, and determine whether the array contains the
   * integer.
   *
   * @param matrix the 2-D array
   * @param target the target value
   * @return whether the array contains the integer
   */
  public boolean findNumberIn2DArraySolution2(int[][] matrix, int target) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return false;
    }

    boolean res = false;
    int rows = matrix.length, cols = matrix[0].length;
    int curRow = rows - 1, curCol = 0;
    while (curRow >= 0 && curCol < cols) {
      int value = matrix[curRow][curCol];
      if (value == target) {
        res = true;
        break;
      } else if (value > target) {
        curRow--;
      } else {
        curCol++;
      }
    }

    return res;
  }

}
