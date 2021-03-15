package cn.mghio.leetcode.array;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

/**
 * Test for {@link DiagonalOrder}
 *
 * @author mghio
 * @since 2021-03-15
 */
public class DiagonalOrderTest {

  private final DiagonalOrder diagonalOrder = new DiagonalOrder();

  /**
   * Input: [ [ 1, 2, 3 ], [ 4, 5, 6 ], [ 7, 8, 9 ] ]
   *
   * Output:  [1, 2, 4, 7, 5, 3, 6, 8, 9]
   */
  @Test
  public void testCase1() {
    int[][] input = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    int[] expected = {1, 2, 4, 7, 5, 3, 6, 8, 9};
    int[] actual = diagonalOrder.solution1(input);
    assertArrayEquals(expected, actual);
  }

}
