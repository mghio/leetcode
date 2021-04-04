package cn.mghio.leetcode.string;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * @author mghio
 * @since 2021-04-04
 */
public class ReverseWordsTest {

  private final ReverseWords reverseWords = new ReverseWords();

  /**
   * 输入："the sky is blue" 输出："blue is sky the"
   */
  @Test
  public void testCase1() {
    String s = "the sky is blue";
    String result = reverseWords.reverseWords(s);
    String expected = "blue is sky the";
    assertEquals(expected, result);
  }

  /**
   * 输入："  hello world!  "
   * 输出："world! hello"
   * 解释：输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
   */
  @Test
  public void testCase2() {
    String s = "  hello world!  ";
    String result = reverseWords.reverseWords(s);
    String expected = "world! hello";
    assertEquals(expected, result);
  }

  /**
   * 输入："a good   example"
   * 输出："example good a"
   * 解释：如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
   */
  @Test
  public void testCase3() {
    String s = "a good   example";
    String result = reverseWords.reverseWords(s);
    String expected = "example good a";
    assertEquals(expected, result);
  }

  /**
   * 输入：s = "  Bob    Loves  Alice   "
   * 输出："Alice Loves Bob"
   */
  @Test
  public void testCase4() {
    String s = "  Bob    Loves  Alice   ";
    String result = reverseWords.reverseWords(s);
    String expected = "Alice Loves Bob";
    assertEquals(expected, result);
  }

  /**
   * 输入：s = "Alice does not even like bob"
   * 输出："bob like even not does Alice"
   */
  @Test
  public void testCase5() {
    String s = "Alice does not even like bob";
    String result = reverseWords.reverseWords(s);
    String expected = "bob like even not does Alice";
    assertEquals(expected, result);
  }

}
