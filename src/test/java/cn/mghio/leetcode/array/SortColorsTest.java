package cn.mghio.leetcode.array;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

/**
 * @author mghio
 * @since 2021-03-28
 */
public class SortColorsTest {

  private final SortColors sortColors = new SortColors();

  /**
   * 输入：nums = [2,0,2,1,1,0] 输出：[0,0,1,1,2,2]
   */
  @Test
  public void testCase1() {
    int[] nums = new int[]{2, 0, 2, 1, 1, 0};
    int[] excepted = new int[]{0, 0, 1, 1, 2, 2};
    sortColors.sortColors(nums);
    assertArrayEquals(excepted, nums);
  }

  /**
   * 输入：nums = [2,0,1] 输出：[0,1,2]
   */
  @Test
  public void testCase2() {
    int[] nums = new int[]{2, 0, 1};
    int[] excepted = new int[]{0, 1, 2};
    sortColors.sortColors(nums);
    assertArrayEquals(excepted, nums);
  }

  /**
   * 输入：nums = [0] 输出：[0]
   */
  @Test
  public void testCase3() {
    int[] nums = new int[]{0};
    int[] excepted = new int[]{0};
    sortColors.sortColors(nums);
    assertArrayEquals(excepted, nums);
  }

  /**
   * 输入：nums = [1] 输出：[1]
   */
  @Test
  public void testCase4() {
    int[] nums = new int[]{1};
    int[] excepted = new int[]{1};
    sortColors.sortColors(nums);
    assertArrayEquals(excepted, nums);
  }

}
