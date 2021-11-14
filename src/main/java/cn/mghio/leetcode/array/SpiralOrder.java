package cn.mghio.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 *
 * @author mghio
 * @since 2021-11-13
 */
public class SpiralOrder {

  /**
   * Return all elements of the matrix in spiral order.
   *
   * @param matrix the matrix
   * @return the elements of the matrix in spiral order
   */
  public List<Integer> spiralOrder(int[][] matrix) {
    if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
      return new ArrayList<>();
    }

    int m = matrix.length;
    int n = matrix[0].length;
    List<Integer> ans = new ArrayList<>();
    boolean[][] visited = new boolean[m][n];
    int total = m * n;
    int row = 0;
    int column = 0;
    // {0, 1}  =>  left   -> right
    // {1, 0}  =>  top    -> bottom
    // {0, -1} =>  right  -> left
    // {-1, 0} =>  bottom -> top
    int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int directionIndex = 0;
    for (int i = 0; i < total; i++) {
      ans.add(matrix[row][column]);
      visited[row][column] = true;
      int nextRow = row + directions[directionIndex][0];
      int nextColumn = column + directions[directionIndex][1];
      if (nextRow < 0 || nextRow >= m
          || nextColumn < 0 || nextColumn >= n
          || visited[nextRow][nextColumn]) {
        directionIndex = (directionIndex + 1) % 4;
      }
      row += directions[directionIndex][0];
      column += directions[directionIndex][1];
    }

    return ans;
  }

}
