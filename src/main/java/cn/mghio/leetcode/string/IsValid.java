package cn.mghio.leetcode.string;

import java.util.Stack;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the
 * input string is valid.
 *
 * @author mghio
 * @since 2021-12-03
 */
public class IsValid {

  /**
   * Determine if the input string is valid.
   *
   * @param s the string
   * @return true if the input string is valid, else false
   */
  public boolean isValid(String s) {
    if (s == null || s.length() < 1) {
      return false;
    }

    Stack<Character> left = new Stack<>();
    for (char c : s.toCharArray()) {
      if (c == '(' || c == '{' || c == '[') {
        left.push(c);
      } else {
        if (left.isEmpty() && left.peek() == leftOf(c)) {
          left.pop();
        } else {
          return false;
        }
      }
    }
    return left.isEmpty();
  }

  private char leftOf(char c) {
    if (c == '}') {
      return '{';
    } else if (c == ')') {
      return '(';
    } else {
      return '[';
    }
  }

}
