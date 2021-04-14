package cn.mghio.leetcode.array;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * @author mghio
 * @since 2021-04-12
 */
public class PascalTriangle2Test {

  private final PascalTriangle2 pascalTriangle2 = new PascalTriangle2();

  /**
   * 输入: 3 输出: [1,3,3,1]
   */
  @Test
  public void testCase1() {
    int numRows = 3;
    List<Integer> actualResult = pascalTriangle2.getRow(numRows);
    List<Integer> expectedResult = Arrays.asList(1, 3, 3, 1);
    assertArrayEquals(actualResult.toArray(new Integer[0]), expectedResult.toArray(new Integer[0]));
  }

}
