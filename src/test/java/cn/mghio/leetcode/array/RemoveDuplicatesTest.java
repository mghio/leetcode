package cn.mghio.leetcode.array;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * @author mghio
 * @since 2021-03-28
 */
public class RemoveDuplicatesTest {

  private final RemoveDuplicates removeDuplicates = new RemoveDuplicates();

  /**
   * 输入：nums = [1,1,1,2,2,3] 输出：5, nums = [1,1,2,2,3]
   */
  @Test
  public void testCase1() {
    int[] nums = new int[]{1, 1, 1, 2, 2, 3};

    int exceptedLength = 5;
    int[] excepted = new int[]{1, 1, 2, 2, 3};

    int newLength = removeDuplicates.removeDuplicates(nums);

    assertEquals(exceptedLength, newLength);
    int[] actualResult = new int[newLength];
    System.arraycopy(nums, 0, actualResult, 0, newLength);
    assertArrayEquals(excepted, actualResult);
  }

  /**
   * 输入：nums = [0,0,1,1,1,1,2,3,3] 输出：7, nums = [0,0,1,1,2,3,3]
   */
  @Test
  public void testCase2() {
    int[] nums = new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3};

    int exceptedLength = 7;
    int[] excepted = new int[]{0, 0, 1, 1, 2, 3, 3};

    int newLength = removeDuplicates.removeDuplicates(nums);

    assertEquals(exceptedLength, newLength);
    int[] actualResult = new int[newLength];
    System.arraycopy(nums, 0, actualResult, 0, newLength);
    assertArrayEquals(excepted, actualResult);
  }
}
