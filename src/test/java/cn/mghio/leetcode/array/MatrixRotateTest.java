package cn.mghio.leetcode.array;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

/**
 * Test for {@link MatrixRotate}
 *
 * @author mghio
 * @since 2021-03-03
 */
public class MatrixRotateTest {

  private final MatrixRotate matrixRotate = new MatrixRotate();

  /**
   * input: null
   * expected: null
   */
  @Test
  public void testCase1() {
    int[][] matrix = null;
    matrixRotate.rotateSolution1(matrix);

    assertNull(matrix);
  }

  /**
   * input: [
   *         [1,2,3],
   *         [4,5,6],
   *         [7,8,9]
   *        ]
   *
   * output: [
   *          [7,4,1],
   *          [8,5,2],
   *          [9,6,3]
   *         ]
   */
  @Test
  public void testCase2() {
    int[][] sourceMatrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    int[][] expected = {{7, 4, 1}, {8, 5, 2}, {9, 6, 3}};

    matrixRotate.rotateSolution1(sourceMatrix);

    assertEquals(expected.length, sourceMatrix.length);
    assertArrayEquals(expected[0], sourceMatrix[0]);
    assertArrayEquals(expected[1], sourceMatrix[1]);
    assertArrayEquals(expected[2], sourceMatrix[2]);
  }

  /**
   * input: [
   *         [5, 1, 9, 11],
   *         [2, 4, 8, 10],
   *         [13, 3, 6, 7],
   *         [15,14,12, 16]
   *        ]
   *
   * output: [
   *          [15, 13, 2, 5],
   *          [14, 3, 4, 1],
   *          [12, 6, 8, 9],
   *          [16, 7, 10, 11]
   *         ]
   */
  @Test
  public void testCase3() {
    int[][] sourceMatrix = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15,14,12, 16}};
    int[][] expected = {{15, 13, 2, 5}, {14, 3, 4, 1}, {12, 6, 8, 9}, {16, 7, 10, 11}};

    matrixRotate.rotateSolution1(sourceMatrix);

    assertEquals(expected.length, sourceMatrix.length);
    assertArrayEquals(expected[0], sourceMatrix[0]);
    assertArrayEquals(expected[1], sourceMatrix[1]);
    assertArrayEquals(expected[2], sourceMatrix[2]);
  }

}
