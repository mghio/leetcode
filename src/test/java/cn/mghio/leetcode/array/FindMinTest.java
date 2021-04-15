package cn.mghio.leetcode.array;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * @author mghio
 * @since 2021-04-16
 */
public class FindMinTest {

  private final FindMin findMin = new FindMin();

  /**
   * 输入：nums = [3,4,5,1,2]
   * 输出：1
   * 解释：原数组为 [1,2,3,4,5] ，旋转 3 次得到输入数组。
   */
  @Test
  public void testCase1() {
    int[] nums = new int[]{3, 4, 5, 1, 2};
    int actualResult = findMin.findMin(nums);
    int expectedResult = 1;
    assertEquals(expectedResult, actualResult);
  }

  /**
   * 输入：nums = [4,5,6,7,0,1,2]
   * 输出：0
   * 解释：原数组为 [0,1,2,4,5,6,7] ，旋转 4 次得到输入数组。
   */
  @Test
  public void testCase2() {
    int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
    int actualResult = findMin.findMin(nums);
    int expectedResult = 0;
    assertEquals(expectedResult, actualResult);
  }

  /**
   * 输入：nums = [11,13,15,17]
   * 输出：11
   * 解释：原数组为 [11,13,15,17] ，旋转 4 次得到输入数组。
   */
  @Test
  public void testCase3() {
    int[] nums = new int[]{11, 13, 15, 17};
    int actualResult = findMin.findMin(nums);
    int expectedResult = 11;
    assertEquals(expectedResult, actualResult);
  }

}
