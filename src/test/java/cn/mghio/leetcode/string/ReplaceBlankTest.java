package cn.mghio.leetcode.string;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * @author mghio
 * @since 2021-04-18
 */
public class ReplaceBlankTest {

  private final ReplaceBlank replaceBlank = new ReplaceBlank();

  /**
   * 测试用例 1 ：输入的字符串包含空格（空格位于字符串的最前；空格位于字符串的最后面；空格位于字符串的中间；
   * 字符串中有连续多个空格）
   */
  @Test
  public void testCase1() {
    {
      String blankInPrefix = " mghio";
      String exceptBlankInPrefix = "%20mghio";
      String actualBlankInPrefix = replaceBlank.replaceBlank(blankInPrefix);
      assertEquals(exceptBlankInPrefix, actualBlankInPrefix);
    }

    {
      String blankInPrefix = "mghio ";
      String exceptBlankInPrefix = "mghio%20";
      String actualBlankInPrefix = replaceBlank.replaceBlank(blankInPrefix);
      assertEquals(exceptBlankInPrefix, actualBlankInPrefix);
    }

    {
      String blankInPrefix = "m gh io";
      String exceptBlankInPrefix = "m%20gh%20io";
      String actualBlankInPrefix = replaceBlank.replaceBlank(blankInPrefix);
      assertEquals(exceptBlankInPrefix, actualBlankInPrefix);
    }

    {
      String blankInPrefix = "mg  hi o ";
      String exceptBlankInPrefix = "mg%20%20hi%20o%20";
      String actualBlankInPrefix = replaceBlank.replaceBlank(blankInPrefix);
      assertEquals(exceptBlankInPrefix, actualBlankInPrefix);
    }
  }

  /**
   * 测试用例 2 ：输入的字符串中没有空格
   */
  @Test
  public void testCase2() {
    String blankInPrefix = "mghio";
    String exceptBlankInPrefix = "mghio";
    String actualBlankInPrefix = replaceBlank.replaceBlank(blankInPrefix);
    assertEquals(exceptBlankInPrefix, actualBlankInPrefix);
  }

  /**
   * 测试用例 3 ：特殊输入情况测试，输入的字符串是一个空指针；输入的字符串是一个空字符串；字符串只有一个空字符串；
   * 字符串中有连续多个空格
   */
  @Test
  public void testCase3() {
    {
      String blankInPrefix = null;
      String exceptBlankInPrefix = "";
      String actualBlankInPrefix = replaceBlank.replaceBlank(blankInPrefix);
      assertEquals(exceptBlankInPrefix, actualBlankInPrefix);
    }

    {
      String blankInPrefix = "";
      String exceptBlankInPrefix = "";
      String actualBlankInPrefix = replaceBlank.replaceBlank(blankInPrefix);
      assertEquals(exceptBlankInPrefix, actualBlankInPrefix);
    }

    {
      String blankInPrefix = " ";
      String exceptBlankInPrefix = "%20";
      String actualBlankInPrefix = replaceBlank.replaceBlank(blankInPrefix);
      assertEquals(exceptBlankInPrefix, actualBlankInPrefix);
    }

    {
      String blankInPrefix = "   ";
      String exceptBlankInPrefix = "%20%20%20";
      String actualBlankInPrefix = replaceBlank.replaceBlank(blankInPrefix);
      assertEquals(exceptBlankInPrefix, actualBlankInPrefix);
    }
  }

}
