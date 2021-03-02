package cn.mghio.leetcode.array;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Test for {@link PivotIndex}
 *
 * @author mghio
 * @since 2021-03-02
 */
public class PivotIndexTest {

  private final PivotIndex pivotIndex = new PivotIndex();

  /**
   * case 1: nums = [1,7,3,6,5,6], excepted result: 3
   */
  @Test
  public void testCase1() {
    int[] nums = new int[]{1, 7, 3, 6, 5, 6};
    int pivotIndex1 = pivotIndex.pivotIndex(nums);
    assertEquals(3, pivotIndex1);
  }

  /**
   * case 2: nums = [1,2,3], excepted result: -1
   */
  @Test
  public void testCase2() {
    int[] nums = new int[]{1, 2, 3};
    int pivotIndex2 = pivotIndex.pivotIndex(nums);
    assertEquals(-1, pivotIndex2);
  }

  /**
   * case 3: nums = [2,1,-1], excepted result: 0
   */
  @Test
  public void testCase3() {
    int[] nums = new int[]{2, 1, -1};
    int pivotIndex3 = pivotIndex.pivotIndex(nums);
    assertEquals(0, pivotIndex3);
  }

  /**
   * case 4: nums = null, excepted result: -1
   */
  @Test
  public void testCase4() {
    int[] nums = null;
    int pivotIndex4 = pivotIndex.pivotIndex(nums);
    assertEquals(-1, pivotIndex4);
  }

  /**
   * case 5: nums = [2, 4], expected result: -1
   */
  @Test
  public void testCase5() {
    int[] nums = new int[]{2, 4};
    int pivotIndex5 = pivotIndex.pivotIndex(nums);
    assertEquals(-1, pivotIndex5);
  }

}
