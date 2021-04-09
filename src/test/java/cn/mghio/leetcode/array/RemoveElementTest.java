package cn.mghio.leetcode.array;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * @author mghio
 * @since 2021-04-09
 */
public class RemoveElementTest {

  private final RemoveElement removeElement = new RemoveElement();

  /**
   * 输入：nums = [3,2,2,3], val = 3
   * 输出：2, nums = [2,2]
   * 解释：函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。你不需要考虑数组中超出新长度后面的元素。
   * 例如，函数返回的新长度为 2 ，而 nums = [2,2,3,3] 或 nums = [2,2,0,0]，也会被视作正确答案。
   */
  @Test
  public void testCase1() {
    int[] nums = new int[]{3, 2, 2, 3};
    int target = 3;
    int newLen = removeElement.removeElement(nums, target);
    int exceptedNewLen = 2;
    int[] exceptedNewArr = new int[]{2, 2, 3, 3};
    assertEquals(exceptedNewLen, newLen);
    assertArrayEquals(exceptedNewArr, nums);
  }

  /**
   * 输入：nums = [0,1,2,2,3,0,4,2], val = 2
   * 输出：5, nums = [0,1,4,0,3]
   * 解释：函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
   * 注意这五个元素可为任意顺序。你不需要考虑数组中超出新长度后面的元素。
   */
  @Test
  public void testCase2() {
    int[] nums = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
    int target = 2;
    int newLen = removeElement.removeElement(nums, target);
    int exceptedNewLen = 5;
    int[] exceptedNewArr = new int[]{0, 1, 3, 0, 4, 2, 2, 2};
    assertEquals(exceptedNewLen, newLen);
    assertArrayEquals(exceptedNewArr, nums);
  }

}
