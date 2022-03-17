package cn.mghio.leetcode.string;

/**
 * Minimum Insertions to Balance a Parentheses String.
 *
 * @author mghio
 * @since 2022-03-17
 */
public class MinInsertions {

  public int minInsertions(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }

    int needLeftCnt = 0;
    int needRightCnt = 0;
    for (int i = 0; i < s.length(); i++) {
      char curChar = s.charAt(i);
      if (curChar == '(') {
        needRightCnt += 2;
        if (needRightCnt % 2 == 1) {
          needLeftCnt++;
          needRightCnt--;
        }
      }

      if (curChar == ')') {
        needRightCnt--;
        if (needRightCnt == -1) {
          needLeftCnt++;
          needRightCnt = 1;
        }
      }
    }

    return needLeftCnt + needRightCnt;
  }

}
