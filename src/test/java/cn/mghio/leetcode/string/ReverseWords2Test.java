package cn.mghio.leetcode.string;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * @author mghio
 * @since 2021-04-14
 */
public class ReverseWords2Test {

  private final ReverseWords2 reverseWords2 = new ReverseWords2();

  /**
   * 示例：
   *
   * 输入："Let's take LeetCode contest"
   * 输出："s'teL ekat edoCteeL tsetnoc"
   */
  @Test
  public void testCase1() {
    String s = "Let's take LeetCode contest";
    String result = reverseWords2.reverseWords(s);
    String expectedResult = "s'teL ekat edoCteeL tsetnoc";
    assertEquals(expectedResult, result);
  }

}
