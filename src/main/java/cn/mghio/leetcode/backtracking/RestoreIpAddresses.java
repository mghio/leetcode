package cn.mghio.leetcode.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * A valid IP address consists of exactly four integers separated by single dots. Each integer is
 * between 0 and 255 (inclusive) and cannot have leading zeros.
 *
 * @author mghio
 * @since 2021-12-19
 */
public class RestoreIpAddresses {

  private static final String DOT = ".";

  /**
   * Return all possible valid IP addresses that can be formed by inserting dots into s.
   *
   * @param s the string s
   * @return the all possible valid IP addresses
   */
  public List<String> restoreIpAddresses(String s) {
    if (s == null || s.length() == 0) {
      return new ArrayList<>();
    }

    int len = s.length();
    if (len < 4 || len > 12) {
      return new ArrayList<>();
    }

    List<String> ans = new ArrayList<>();
    LinkedList<String> path = new LinkedList<>();
    int splitTimes = 0;
    dfs(s, len, splitTimes, 0, path, ans);
    return ans;
  }

  private void dfs(String s, int len, int splitTimes, int begin, LinkedList<String> path,
      List<String> ans) {
    if (begin == len) {
      if (splitTimes == 4) {
        ans.add(String.join(DOT, path));
      }
      return;
    }

    if (len - begin < (4 - splitTimes) || len - begin > 3 * (4 - splitTimes)) {
      return;
    }

    for (int i = 0; i < 3; i++) {
      if (begin + i >= len) {
        break;
      }

      int ipSegment = judgeIfIpSegment(s, begin, begin + i);
      if (ipSegment != -1) {
        path.addLast(ipSegment + "");
        dfs(s, len, splitTimes + 1, begin + i + 1, path, ans);
        path.removeLast();
      }
    }
  }

  private int judgeIfIpSegment(String s, int left, int right) {
    int len = right - left + 1;
    if (len > 1 && s.charAt(left) == '0') {
      return -1;
    }

    int res = 0;
    for (int i = left; i <= right; i++) {
      res = res * 10 + s.charAt(i) - '0';
    }

    return res > 255 ? -1 : res;
  }

}
