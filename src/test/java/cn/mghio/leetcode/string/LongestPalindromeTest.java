package cn.mghio.leetcode.string;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * @author mghio
 * @since 2021-04-02
 */
public class LongestPalindromeTest {

  private final LongestPalindrome longestPalindrome = new LongestPalindrome();

  /**
   * 输入：s = "babad" 输出："bab" 解释："aba" 同样是符合题意的答案。
   */
  @Test
  public void testCase1() {
    String s = "babad";
    String result = longestPalindrome.longestPalindrome(s);
    List<String> expectedList = new ArrayList<>(2);
    expectedList.add("bab");
    expectedList.add("aba");
    assertTrue(expectedList.contains(result));
  }

  /**
   * 输入：s = "cbbd" 输出："bb"
   */
  @Test
  public void testCase2() {
    String s = "cbbd";
    String result = longestPalindrome.longestPalindrome(s);
    String expectedResult = "bb";
    assertEquals(expectedResult, result);
  }

  /**
   * 输入：s = "a" 输出："a"
   */
  @Test
  public void testCase3() {
    String s = "a";
    String result = longestPalindrome.longestPalindrome(s);
    String expectedResult = "a";
    assertEquals(expectedResult, result);
  }

  /**
   * 输入：s = "ac" 输出："a"
   */
  @Test
  public void testCase4() {
    String s = "ac";
    String result = longestPalindrome.longestPalindrome(s);
    String expectedResult = "a";
    assertEquals(expectedResult, result);
  }

}
