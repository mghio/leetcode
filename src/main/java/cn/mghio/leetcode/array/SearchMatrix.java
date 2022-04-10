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

  /**
   * Search for a target value in an m x n integer matrix.
   *
   * @param matrix the matrix array
   * @param target the target value
   * @return true is contains target value, else false
   */
  public boolean searchMatrixSolution3(int[][] matrix, int target) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return false;
    }

    boolean found = false;
    for (int[] row : matrix) {
      for (int element : row) {
        if (element == target) {
          found = true;
          break;
        }
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
  public boolean searchMatrixSolution4(int[][] matrix, int target) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return false;
    }

    boolean found = false;
    for (int[] row : matrix) {
      int index = binarySearch(row, target);
      if (index > 0) {
        found = true;
        break;
      }
    }

    return found;
  }

  /**
   * Search matrix.
   */
  public boolean searchMatrix5(int[][] matrix, int target) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return false;
    }

    int row = matrix.length;
    int col = matrix[0].length;
    int i = 0;
    int j = col - 1;

    while (i < row && j >= 0) {
      int cur = matrix[i][j];
      if (cur == target) {
        return true;
      }

      if (cur > target) {
        j--;
      } else {
        i++;
      }
    }

    return false;
  }


  /**
   * Search matrix.
   */
  public boolean searchMatrix6(int[][] matrix, int target) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return false;
    }

    int row = matrix.length;
    int col = matrix[0].length;
    int i = row - 1;
    int j = 0;

    while (i >= 0 && j < col) {
      int cur = matrix[i][j];
      if (cur == target) {
        return true;
      }

      if (cur > target) {
        i--;
      } else {
        j++;
      }
    }

    return false;
  }

  private int binarySearch(int[] row, int target) {
    int l = 0;
    int h = row.length - 1;

    while (l <= h) {
      int mid = l + (h - l) / 2;
      int midVal = row[mid];

      if (midVal == target) {
        return mid;
      } else if (midVal < target) {
        l = mid + 1;
      } else {
        h = mid - 1;
      }
    }

    return -1;
  }

}
