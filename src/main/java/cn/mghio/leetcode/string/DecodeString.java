package cn.mghio.leetcode.string;

import java.util.Collections;
import java.util.LinkedList;

/**
 * Decode String.
 *
 * @author mghio
 * @since 2022-04-04
 */
public class DecodeString {

  int point;

  public String decodeString(String s) {
    if (s == null || s.length() == 0) {
      return "";
    }

    LinkedList<String> stack = new LinkedList<>();
    point = 0;
    while (point < s.length()) {
      char curr = s.charAt(point);
      if (Character.isDigit(curr)) {
        String digits = getDigits(s);
        stack.add(digits);
      } else if (Character.isLetter(curr) || curr == '['){
        stack.addLast(String.valueOf(s.charAt(point++)));
      } else {
        point++;
        LinkedList<String> sub = new LinkedList<>();
        while (!"[".equals(stack.peekLast())) {
          sub.addLast(stack.removeLast());
        }
        Collections.reverse(sub);
        stack.removeLast();
        int repeatTimes = Integer.parseInt(stack.removeLast());
        StringBuilder sb = new StringBuilder();
        String str = getString(sub);
        while (repeatTimes-- > 0) {
          sb.append(str);
        }
        stack.addLast(sb.toString());
      }
    }
    return getString(stack);
  }

  private String getDigits(String s) {
    StringBuilder sb = new StringBuilder();
    while (Character.isDigit(s.charAt(point))) {
      sb.append(s.charAt(point++));
    }
    return sb.toString();
  }

  private String getString(LinkedList<String> list) {
    StringBuilder sb = new StringBuilder();
    for (String s : list) {
      sb.append(s);
    }
    return sb.toString();
  }

}
