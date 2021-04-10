package cn.mghio.leetcode.array;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * @author mghio
 * @since 2021-04-10
 */
public class MinSubArrayLenTest {

  private final MinSubArrayLen arrayLen = new MinSubArrayLen();

  /**
   * 输入：target = 7, nums = [2,3,1,2,4,3] 输出：2 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
   */
  @Test
  public void testCase1() {
    int[] nums = new int[]{2, 3, 1, 2, 4, 3};
    int target = 7;
    int minLen = arrayLen.minSubArrayLen(target, nums);
    int exceptedMinLen = 2;
    assertEquals(exceptedMinLen, minLen);
  }

  /**
   * 输入：target = 4, nums = [1,4,4] 输出：1
   */
  @Test
  public void testCase2() {
    int[] nums = new int[]{1, 4, 4};
    int target = 4;
    int minLen = arrayLen.minSubArrayLen(target, nums);
    int exceptedMinLen = 1;
    assertEquals(exceptedMinLen, minLen);
  }

  /**
   * 输入：target = 11, nums = [1,1,1,1,1,1,1,1] 输出：0
   */
  @Test
  public void testCase3() {
    int[] nums = new int[]{1, 1, 1, 1, 1, 1, 1, 1};
    int target = 11;
    int minLen = arrayLen.minSubArrayLen(target, nums);
    int exceptedMinLen = 0;
    assertEquals(exceptedMinLen, minLen);
  }

}
