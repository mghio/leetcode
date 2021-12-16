package cn.mghio.leetcode.backtracking;

/**
 * There is a 8x8 chessboard, and I hope to put 8 pieces (queen) in it. Each piece cannot have
 * another piece on the row, column, or diagonal.
 *
 * @author mghio
 * @since 2021-12-16
 */
public class EightQueen {

  /**
   * The index represent the row, the value represent which column the queen is stored in
   */
  private final int[] result = new int[8];

  /**
   * Given an 8 X 8 chessboard, an put 8 pieces (queen) in it, Each piece cannot have anther piece on
   * the row, column, or diagonal.
   *
   * @param row the row number
   * @return the 8 queen location array
   */
  public int[] cal8Queen(int row) {
    if (row == 8) {
      return result;
    }

    for (int column = 0; column < 8; column++) {
      if (isOk(row, column)) {
        result[row] = column;
        cal8Queen(row + 1);
      }
    }

    return result;
  }

  private boolean isOk(int row, int column) {
    int leftUp = column - 1;
    int rightUp = column + 1;

    for (int i = row - 1; i > 0; i--) {
      // the row(i), column already store queen?
      if (result[i] == column) {
        return false;
      }

      if (leftUp > 0) {
        // the row(i), column(leftUp) already store queen?
        if (result[i] == leftUp) {
          return false;
        }
      }

      if (rightUp < 8) {
        // the row(i), column(rightUp) already store queen?
        if (result[i] == rightUp) {
          return false;
        }
      }

      --leftUp;
      ++rightUp;
    }

    return true;
  }

}
