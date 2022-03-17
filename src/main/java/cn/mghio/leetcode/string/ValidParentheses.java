package cn.mghio.leetcode.string;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Valid Parentheses.
 *
 * @author mghio
 * @since 2022-03-17
 */
public class ValidParentheses {

  public boolean isValid(String s) {
    if (s == null || s.length() == 0) {
      return true;
    }

    Deque<Character> left = new ArrayDeque<>();
    for (int i = 0; i < s.length(); i++) {
      char curChar = s.charAt(i);
      if (curChar == '(' || curChar == '{' || curChar == '[') {
        left.push(curChar);
      } else {
        if (!left.isEmpty() && getLeft(curChar) == left.peek()) {
          left.pop();
        } else {
          return false;
        }
      }
    }

    return left.isEmpty();
  }

  private Character getLeft(char curChar) {
    switch (curChar) {
      case '}':
        return '{';
      case ']':
        return '[';
      case ')':
      default:
        return '(';
    }
  }

}
