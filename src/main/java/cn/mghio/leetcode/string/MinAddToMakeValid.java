package cn.mghio.leetcode.string;

/**
 * Minimum Add to Make Parentheses Valid.
 *
 * @author mghio
 * @since 2022-03-17
 */
public class MinAddToMakeValid {

  public int minAddToMakeValid(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }

    int needLeftCnt = 0;
    int needRightCnt = 0;

    for (int i = 0; i < s.length(); i++) {
      char curChar = s.charAt(i);
      if (curChar == '(') {
        needRightCnt++;
      }

      if (curChar == ')') {
        needRightCnt--;
        if (needRightCnt == -1) {
          needRightCnt = 0;
          needLeftCnt++;
        }
      }
    }

    return needLeftCnt + needRightCnt;
  }

}
