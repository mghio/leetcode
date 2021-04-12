package cn.mghio.leetcode.array;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * @author mghio
 * @since 2021-04-12
 */
public class PascalTriangleTest {

  private final PascalTriangle pascalTriangle = new PascalTriangle();

  /**
   * 输入: 5
   * 输出:
   * [
   *      [1],
   *     [1,1],
   *    [1,2,1],
   *   [1,3,3,1],
   *  [1,4,6,4,1]
   * ]
   */
  @Test
  public void testCase1() {
    int numRows = 5;
    List<List<Integer>> actualResult = pascalTriangle.generate(numRows);
    List<List<Integer>> expectedResult = new ArrayList<>();
    expectedResult.add(Collections.singletonList(1));
    expectedResult.add(Arrays.asList(1, 1));
    expectedResult.add(Arrays.asList(1, 2, 1));
    expectedResult.add(Arrays.asList(1, 3, 3, 1));
    expectedResult.add(Arrays.asList(1, 4, 6, 4, 1));

    for (int i = 0; i < actualResult.size(); i++) {
      assertArrayEquals(actualResult.get(i).toArray(new Integer[0]),
          expectedResult.get(i).toArray(new Integer[0]));
    }
  }

}
