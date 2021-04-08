package cn.mghio.leetcode.array;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

/**
 * @author mghio
 * @since 2021-04-08
 */
public class TwoSumTest {

  private final TwoSum twoSum = new TwoSum();

  /**
   * 输入：numbers = [2,7,11,15], target = 9 输出：[1,2] 解释：2 与 7 之和等于目标数 9 。 因此 index1 = 1, index2 = 2 。
   */
  @Test
  public void testCase1() {
    int[] numbers = new int[]{2, 7, 11, 15};
    int target = 9;
    int[] exceptedResult = new int[]{1, 2};
    int[] result = twoSum.twoSum(numbers, target);
    assertArrayEquals(exceptedResult, result);
  }

  /**
   * 输入：numbers = [2,3,4], target = 6 输出：[1,3]
   */
  @Test
  public void testCase2() {
    int[] numbers = new int[]{2, 3, 4};
    int target = 6;
    int[] exceptedResult = new int[]{1, 3};
    int[] result = twoSum.twoSum(numbers, target);
    assertArrayEquals(exceptedResult, result);
  }

  /**
   * 输入：numbers = [-1,0], target = -1 输出：[1,2]
   */
  @Test
  public void testCase3() {
    int[] numbers = new int[]{-1, 0};
    int target = -1;
    int[] exceptedResult = new int[]{1, 2};
    int[] result = twoSum.twoSum(numbers, target);
    assertArrayEquals(exceptedResult, result);
  }

}
