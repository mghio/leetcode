package cn.mghio.leetcode.array;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * @author mghio
 * @since 2021-04-07
 */
public class ArrayPairSumTest {

  private final ArrayPairSum arrayPairSum = new ArrayPairSum();

  /**
   * 输入：nums = [1,4,3,2]
   * 输出：4
   * 解释：所有可能的分法（忽略元素顺序）为：
   * 1. (1, 4), (2, 3) -> min(1, 4) + min(2, 3) = 1 + 2 = 3
   * 2. (1, 3), (2, 4) -> min(1, 3) + min(2, 4) = 1 + 2 = 3
   * 3. (1, 2), (3, 4) -> min(1, 2) + min(3, 4) = 1 + 3 = 4
   * 所以最大总和为 4
   */
  @Test
  public void testCase1() {
    int[] nums = new int[]{1, 4, 3, 2};
    int expectedResult = 4;
    int actualResult = arrayPairSum.arrayPairSum(nums);
    assertEquals(expectedResult, actualResult);
  }

  /**
   * 输入：nums = [6,2,6,5,1,2]
   * 输出：9
   * 解释：最优的分法为 (2, 1), (2, 5), (6, 6).
   * min(2, 1) + min(2, 5) + min(6, 6) = 1 + 2 + 6 = 9
   * 所以最大总和为 9
   */
  @Test
  public void testCase2() {
    int[] nums = new int[]{6, 2, 6, 5, 1, 2};
    int expectedResult = 9;
    int actualResult = arrayPairSum.arrayPairSum(nums);
    assertEquals(expectedResult, actualResult);
  }

}
