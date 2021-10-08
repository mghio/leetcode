package java.cn.mghio.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two
 * queens attack each other.
 *
 * Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the
 * answer in any order.
 *
 * @author mghio
 * @since 2021-10-08
 */
public class NQueens {

  private static final char NULL = '.';
  private static final char QUEEN = 'Q';

  public List<List<String>> solveNQueens(int n) {
    List<List<String>> rets = new ArrayList<>();

    int[] queens = new int[n];
    Arrays.fill(queens, -1);
    // columns
    Set<Integer> columns = new HashSet<>();
    // left up -> right down diagonals
    Set<Integer> diagonals1 = new HashSet<>();
    // right up -> left down diagonals
    Set<Integer> diagonals2 = new HashSet<>();

    backTrack(rets, queens, n, 0, columns, diagonals1, diagonals2);
    return rets;
  }

  private void backTrack(List<List<String>> rets, int[] queens, int n, int row,
      Set<Integer> columns, Set<Integer> diagonals1, Set<Integer> diagonals2) {

    if (n == row) {
      List<String> board = generateBoard(queens, n);
      rets.add(board);
    } else {
      for (int i = 0; i < n; i++) {
        if (columns.contains(i)) {
          continue;
        }

        int diagonal1 = row - i;
        if (diagonals1.contains(diagonal1)) {
          continue;
        }

        int diagonal2 = row + i;
        if (diagonals2.contains(diagonal2)) {
          continue;
        }

        queens[row] = i;
        columns.add(i);
        diagonals1.add(diagonal1);
        diagonals2.add(diagonal2);

        backTrack(rets, queens, n, row + 1, columns, diagonals1, diagonals2);

        queens[row] = -1;
        columns.remove(i);
        diagonals1.remove(diagonal1);
        diagonals2.remove(diagonal2);
      }
    }
  }

  private List<String> generateBoard(int[] queens, int n) {
    List<String> ret = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      char[] rows = new char[n];
      Arrays.fill(rows, NULL);
      rows[queens[i]] = QUEEN;
      ret.add(new String(rows));
    }
    return ret;
  }

}
