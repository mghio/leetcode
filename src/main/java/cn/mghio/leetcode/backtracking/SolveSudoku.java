package cn.mghio.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 *
 * @author mghio
 * @since 2021-12-18
 */
public class SolveSudoku {

  private boolean valid = false;
  private final boolean[][] line = new boolean[9][9];
  private final boolean[][] column = new boolean[9][9];
  private final boolean[][][] block = new boolean[3][3][9];
  private final List<int[]> spaces = new ArrayList<>();

  private static final char NO_NUMBER = '.';

  /**
   * Write a program to solve a Sudoku puzzle by filling the empty cells.
   *
   * @param board the array
   */
  public void solveSudokuSolution1(char[][] board) {
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        if (board[i][j] == NO_NUMBER) {
          spaces.add(new int[]{i, j});
        } else {
          int digit = board[i][j] - '0' - 1;
          _setFlag(i, j, digit, true);
        }
      }
    }

    _dfs(board, 0);
  }

  private void _dfs(char[][] board, int pos) {
    if (pos == spaces.size()) {
      valid = true;
      return;
    }

    int[] space = spaces.get(pos);
    int i = space[0];
    int j = space[1];
    for (int digit = 0; digit < 9 && !valid; digit++) {
      if (!line[i][digit] && !column[j][digit] && !block[i / 3][j / 3][digit]) {
        _setFlag(i, j, digit, true);
        board[i][j] = (char) (digit + '0' + 1);
        _dfs(board, pos + 1);
        // NOTE: When backtracking to the current recursion level,
        // we also need to reset the above three values to False.
        _setFlag(i, j, digit, false);
      }
    }
  }

  private void _setFlag(int i, int j, int digit, boolean flag) {
    line[i][digit] = flag;
    column[j][digit] = flag;
    block[i / 3][j / 3][digit] = flag;
  }

}
