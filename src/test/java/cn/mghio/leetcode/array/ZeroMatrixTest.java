package cn.mghio.leetcode.array;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Test for {@link ZeroMatrix}
 *
 * @author mghio
 * @since 2021-03-13
 */
public class ZeroMatrixTest {

  private final ZeroMatrix zeroMatrix = new ZeroMatrix();

  /**
   * Input: [ [1,1,1], [1,0,1], [1,1,1] ] Output: [ [1,0,1], [0,0,0], [1,0,1] ]
   */
  @Test
  public void testCase1ForSolution1() {
    int[][] sourceMatrix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
    int[][] expected = {{1, 0, 1}, {0, 0, 0}, {1, 0, 1}};

    zeroMatrix.solution1(sourceMatrix);

    assertEquals(expected.length, sourceMatrix.length);
    assertArrayEquals(expected[0], sourceMatrix[0]);
    assertArrayEquals(expected[1], sourceMatrix[1]);
    assertArrayEquals(expected[2], sourceMatrix[2]);
  }

  /**
   * Input: [ [0,1,2,0], [3,4,5,2], [1,3,1,5] ] Output: [ [0,0,0,0], [0,4,5,0], [0,3,1,0] ]
   */
  @Test
  public void testCase2ForSolution1() {
    int[][] sourceMatrix = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
    int[][] expected = {{0, 0, 0, 0}, {0, 4, 5, 0}, {0, 3, 1, 0}};

    zeroMatrix.solution1(sourceMatrix);

    assertEquals(expected.length, sourceMatrix.length);
    assertArrayEquals(expected[0], sourceMatrix[0]);
    assertArrayEquals(expected[1], sourceMatrix[1]);
    assertArrayEquals(expected[2], sourceMatrix[2]);
  }


  /**
   * Input: [ [1,1,1], [1,0,1], [1,1,1] ] Output: [ [1,0,1], [0,0,0], [1,0,1] ]
   */
  @Test
  public void testCase1ForSolution2() {
    int[][] sourceMatrix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
    int[][] expected = {{1, 0, 1}, {0, 0, 0}, {1, 0, 1}};

    zeroMatrix.solution2(sourceMatrix);

    assertEquals(expected.length, sourceMatrix.length);
    assertArrayEquals(expected[0], sourceMatrix[0]);
    assertArrayEquals(expected[1], sourceMatrix[1]);
    assertArrayEquals(expected[2], sourceMatrix[2]);
  }

  /**
   * Input: [ [0,1,2,0], [3,4,5,2], [1,3,1,5] ] Output: [ [0,0,0,0], [0,4,5,0], [0,3,1,0] ]
   */
  @Test
  public void testCase2ForSolution2() {
    int[][] sourceMatrix = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
    int[][] expected = {{0, 0, 0, 0}, {0, 4, 5, 0}, {0, 3, 1, 0}};

    zeroMatrix.solution2(sourceMatrix);

    assertEquals(expected.length, sourceMatrix.length);
    assertArrayEquals(expected[0], sourceMatrix[0]);
    assertArrayEquals(expected[1], sourceMatrix[1]);
    assertArrayEquals(expected[2], sourceMatrix[2]);
  }

}
