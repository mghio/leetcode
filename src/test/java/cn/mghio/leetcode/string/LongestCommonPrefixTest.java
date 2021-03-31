package cn.mghio.leetcode.string;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * @author mghio
 * @since 2021-03-31
 */
public class LongestCommonPrefixTest {

  private final LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();

  /**
   * 输入：strs = ["flower","flow","flight"] 输出："fl"
   */
  @Test
  public void testCase1() {
    String[] strs = new String[]{"flower", "flow", "flight"};
    String result = "fl";
    assertEquals(result, longestCommonPrefix.longestCommonPrefix(strs));
  }

  /**
   * 输入：strs = ["dog","racecar","car"] 输出：""
   */
  @Test
  public void testCase2() {
    String[] strs = new String[]{"dog", "racecar", "car"};
    String result = "";
    assertEquals(result, longestCommonPrefix.longestCommonPrefix(strs));
  }

}
