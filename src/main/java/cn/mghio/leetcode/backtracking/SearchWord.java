package cn.mghio.leetcode.backtracking;

/**
 * Given an m x n grid of characters board and a string word, return true if word exists in the
 * grid.
 *
 * @author mghio
 * @since 2021-12-19
 */
public class SearchWord {

  /**
   * Given an m x n grid of characters board and a string word, return true if word exists in the
   * grid.
   *
   * @param board the m x n grid
   * @param word the word
   * @return true represent exist, else false
   */
  public boolean exist(char[][] board, String word) {
    int h = board.length;
    int w = board[0].length;
    boolean[][] visited = new boolean[h][w];

    for (int i = 0; i < h; i++) {
      for (int j = 0; j < w; j++) {
        boolean flag = check(board, visited, i, j, word, 0);
        if (flag) {
          return true;
        }
      }
    }

    return false;
  }

  private boolean check(char[][] board, boolean[][] visited, int i, int j, String word, int k) {
    if (board[i][j] != word.charAt(k)) {
      return false;
    }

    if (k == word.length() - 1) {
      return true;
    }

    visited[i][j] = true;
    int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    boolean result = false;
    for (int[] direction : directions) {
      int newI = i + direction[0];
      int newJ = j + direction[1];
      if (newI >= 0 && newI < board.length && newJ >= 0 && newJ < board[0].length) {
        if (!visited[newI][newJ]) {
          boolean flag = check(board, visited, newI, newJ, word, k + 1);
          if (flag) {
            result = true;
            break;
          }
        }
      }
    }

    visited[i][j] = false;
    return result;
  }

}
