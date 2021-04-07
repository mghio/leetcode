package cn.mghio.leetcode.string;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

/**
 * @author mghio
 * @since 2021-04-07
 */
public class ReverseStringTest {

  private final ReverseString reverseString = new ReverseString();

  /**
   * 输入：["h","e","l","l","o"] 输出：["o","l","l","e","h"]
   */
  @Test
  public void testCase1() {
    char[] s = new char[]{'h', 'e', 'l', 'l', 'o'};
    char[] result = new char[]{'o', 'l', 'l', 'e', 'h'};
    reverseString.reverseString(s);
    assertArrayEquals(result, s);
  }

  /**
   * 输入：["H","a","n","n","a","h"] 输出：["h","a","n","n","a","H"]
   */
  @Test
  public void testCase2() {
    char[] s = new char[]{'H', 'a', 'n', 'n', 'a', 'h'};
    char[] result = new char[]{'h', 'a', 'n', 'n', 'a', 'H'};
    reverseString.reverseString(s);
    assertArrayEquals(result, s);
  }

}
