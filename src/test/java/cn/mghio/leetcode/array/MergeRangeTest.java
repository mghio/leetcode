package cn.mghio.leetcode.array;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Test for {@link MergeRange}
 *
 * @author mghio
 * @since 2021-03-03
 */
public class MergeRangeTest {

  private final MergeRange mergeRange = new MergeRange();

  /**
   * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
   * 输出：[[1,6],[8,10],[15,18]]
   * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
   */
  @Test
  public void testCase1() {
    int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
    int[][] result = mergeRange.mergeSolution1(intervals);

    assertEquals(3, result.length);
    assertArrayEquals(new int[]{1, 6}, result[0]);
    assertArrayEquals(new int[]{8, 10}, result[1]);
    assertArrayEquals(new int[]{15, 18}, result[2]);
  }

  /**
   * 输入：intervals = [[1,4],[4,5]]
   * 输出：[[1,5]]
   * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
   */
  @Test
  public void testCase2() {
    int[][] intervals = {{1, 4}, {4, 5}};
    int[][] result = mergeRange.mergeSolution1(intervals);

    assertEquals(1, result.length);
    assertArrayEquals(new int[]{1, 5}, result[0]);
  }

  /**
   * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
   * 输出：[[1,6],[8,10],[15,18]]
   * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
   */
  @Test
  public void testSolution2Case1() {
    int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
    int[][] result = mergeRange.mergeSolution2(intervals);

    assertEquals(3, result.length);
    assertArrayEquals(new int[]{1, 6}, result[0]);
    assertArrayEquals(new int[]{8, 10}, result[1]);
    assertArrayEquals(new int[]{15, 18}, result[2]);
  }

  /**
   * 输入：intervals = [[1,4],[4,5]]
   * 输出：[[1,5]]
   * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
   */
  @Test
  public void testSolution2Case2() {
    int[][] intervals = {{1, 4}, {4, 5}};
    int[][] result = mergeRange.mergeSolution2(intervals);

    assertEquals(1, result.length);
    assertArrayEquals(new int[]{1, 5}, result[0]);
  }

}
