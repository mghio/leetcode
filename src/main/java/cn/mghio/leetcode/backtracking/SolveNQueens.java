package cn.mghio.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Eight Queens LCCI.
 *
 * @author mghio
 * @since 2022-03-27
 */
public class SolveNQueens {

  public List<List<String>> solveNQueens(int n) {
    List<List<String>> results = new ArrayList<>();

    char[][] result = new char[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        result[i][j] = '.';
      }
    }

    backtrack(results, result, 0);
    return results;
  }

  private void backtrack(List<List<String>> results, char[][] result, int row) {
    for (int i = 0, len = result.length; i < len; i++) {
      if (isValid(result, row, i)) {
        result[row][i] = 'Q';
        if (row == len - 1) {
          addToResults(results, result);
        } else {
          backtrack(results, result, row + 1);
        }
        result[row][i] = '.';
      }
    }
  }

  private void addToResults(List<List<String>> results, char[][] result) {
    List<String> list = new ArrayList<>(result.length);
    for (char[] value : result) {
      list.add(new String(value));
    }
    results.add(list);
  }

  private boolean isValid(char[][] result, int row, int col) {
    // (0...row, col)
    for (int i = 0; i < row; i++) {
      if (result[i][col] == 'Q') {
        return false;
      }
    }

    // (row - 1, col - 1) ... (1, 1) ... (0, 0)
    for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
      if (result[i][j] == 'Q') {
        return false;
      }
    }

    // (row - 1, col + 1) ... (1, result.length - 2) ... (0, result.length - 1)
    for (int i = row - 1, j = col + 1; i >= 0 && j < result.length; i--, j++) {
      if (result[i][j] == 'Q') {
        return false;
      }
    }

    return true;
  }

}
