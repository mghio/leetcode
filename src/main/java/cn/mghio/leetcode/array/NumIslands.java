package cn.mghio.leetcode.array;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return
 * the number of islands.
 *
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or
 * vertically. You may assume all four edges of the grid are all surrounded by water.
 *
 * @author mghio
 * @since 2022-02-14
 */
public class NumIslands {

  /**
   * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water),
   * return the number of islands.
   *
   * @param grid the grid
   * @return the result
   */
  public int numIsLands(char[][] grid) {
    if (grid == null || grid.length == 0) {
      return 0;
    }

    int res = 0;
    int m = grid.length;
    int n = grid[0].length;

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == '1') {
          res++;
          dfs(grid, i, j);
        }
      }
    }

    return res;
  }

  private final int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

  /**
   * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water),
   * return the number of islands.
   *
   * @param grid the grid
   * @return the result
   */
  public int numIsLandsSolution2(char[][] grid) {
    if (grid == null || grid.length == 0) {
      return 0;
    }

    int res = 0;
    int m = grid.length;
    int n = grid[0].length;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == '1') {
          res++;
          dfs(grid, i, j);
        }
      }
    }
    return res;
  }

  private void dfs(char[][] grid, int i, int j) {
    int m = grid.length;
    int n = grid[0].length;
    if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == '0') {
      return;
    }

    grid[i][j] = '0';
    for (int[] dir : dirs) {
      dfs(grid, i + dir[0], j + dir[1]);
    }
  }

  /**
   * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water),
   * return the number of islands.
   *
   * @param grid the grid
   * @return the result
   */
  public int numIsLandsSolution3(char[][] grid) {
    if (grid == null || grid.length == 0) {
      return 0;
    }

    int res = 0;
    int m = grid.length;
    int n = grid[0].length;

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] != '1') {
          continue;
        }

        ++res;
        grid[i][j] = '0';
        Queue<Integer> neighbors = new LinkedList<>();
        neighbors.add(i * n + j);

        while (!neighbors.isEmpty()) {
          int id = neighbors.remove();
          int row = id / n;
          int col = id % n;

          if (row - 1 > 0 && grid[row - 1][col] == '1') {
            neighbors.add((row - 1) * n + col);
            grid[row - 1][col] = '0';
          }

          if (row + 1 < n && grid[row + 1][col] == '1') {
            neighbors.add((row + 1) * n + col);
            grid[row + 1][col] = '0';
          }

          if (col - 1 >= 0 && grid[row][col - 1] == '1') {
            neighbors.add(row * n + col - 1);
            grid[row][col - 1] = '0';
          }

          if (col + 1 < n && grid[row][col + 1] == '1') {
            neighbors.add(row * n + col + 1);
            grid[row][col + 1] = '0';
          }
        }
      }
    }

    return res;
  }

}
