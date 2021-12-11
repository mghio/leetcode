package cn.mghio.leetcode.array;

/**
 * Write an efficient algorithm that searches for a target value in an m x n integer matrix. The
 * matrix has the following properties:
 *
 * Integers in each row are sorted in ascending from left to right. Integers in each column are
 * sorted in ascending from top to bottom.
 *
 * @author mghio
 * @since 2021-12-11
 */
public class SearchMatrix {

  /**
   * Search for a target value in an m x n integer matrix.
   *
   * @param matrix the matrix array
   * @param target the target value
   * @return true is contains target value, else false
   */
  public boolean searchMatrix(int[][] matrix, int target) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return false;
    }

    boolean found = false;
    int rows = matrix.length;
    int cols = matrix[0].length;

    int row = 0;
    int col = cols - 1;
    while (row < rows && col >= 0) {
      int rightTopValue = matrix[row][col];

      if (rightTopValue == target) {
        found = true;
        break;
      } else if (rightTopValue > target) {
        --col;
      } else {
        ++row;
      }
    }

    return found;
  }

  /**
   * Search for a target value in an m x n integer matrix.
   *
   * @param matrix the matrix array
   * @param target the target value
   * @return true is contains target value, else false
   */
  public boolean searchMatrixSolution2(int[][] matrix, int target) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return false;
    }

    boolean found = false;
    int rows = matrix.length;
    int cols = matrix[0].length;

    int row = rows - 1;
    int col = 0;
    while (row >= 0 && col < cols) {
      int leftDownValue = matrix[row][col];

      if (leftDownValue == target) {
        found = true;
        break;
      } else if (leftDownValue > target) {
        --row;
      } else {
        ++col;
      }
    }

    return found;
  }

}
