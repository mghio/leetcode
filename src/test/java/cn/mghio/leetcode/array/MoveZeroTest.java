package cn.mghio.leetcode.array;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

/**
 * @author mghio
 * @since 2021-03-27
 */
public class MoveZeroTest {

  private final MoveZero moveZero = new MoveZero();

  /**
   * 示例: 输入: [0,1,0,3,12] 输出: [1,3,12,0,0]
   */
  @Test
  public void testCase1() {
    int[] nums = new int[]{0, 1, 0, 3, 12};
    moveZero.moveZeroes(nums);
    int[] exceptedNums = new int[]{1, 3, 12, 0, 0};
    assertArrayEquals(nums, exceptedNums);
  }

}
