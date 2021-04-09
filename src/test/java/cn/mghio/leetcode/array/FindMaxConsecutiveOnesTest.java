package cn.mghio.leetcode.array;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * @author mghio
 * @since 2021-04-10
 */
public class FindMaxConsecutiveOnesTest {

  private final FindMaxConsecutiveOnes findMaxConsecutiveOnes = new FindMaxConsecutiveOnes();

  /**
   * 输入：[1,1,0,1,1,1]
   * 输出：3
   * 解释：开头的两位和最后的三位都是连续 1 ，所以最大连续 1 的个数是 3.
   */
  @Test
  public void testCase1() {
    int[] nums = new int[]{1, 1, 0, 1, 1, 1};
    int maxConsecutiveOnes = findMaxConsecutiveOnes.findMaxConsecutiveOnes(nums);
    int excepted = 3;
    assertEquals(excepted, maxConsecutiveOnes);
  }

  /**
   * 输入：[1,0,1,1,0,1]
   * 输出：2
   * 解释：中间的两位是连续 1 ，所以最大连续 1 的个数是 2.
   */
  @Test
  public void testCase2() {
    int[] nums = new int[]{1, 0, 1, 1, 0, 1};
    int maxConsecutiveOnes = findMaxConsecutiveOnes.findMaxConsecutiveOnes(nums);
    int excepted = 2;
    assertEquals(excepted, maxConsecutiveOnes);
  }

}
