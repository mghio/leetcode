package java.cn.mghio.leetcode.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed
 * parentheses.
 *
 * @author mghio
 * @since 2021-10-30
 */
public class GenerateParenthesis {

  /**
   * Generate all combinations of well-formed parentheses.
   *
   * @param n the n pairs of parentheses
   * @return the all combinations
   */
  public List<String> generateParenthesisForce(int n) {
    List<String> ans = new ArrayList<>();
    generateAll(new char[2 * n], 0, ans);
    return ans;
  }

  /**
   * Generate all combination of well-formed prentheses.
   *
   * @param n the n pairs of parentheses
   * @return the all combinations
   */
  public List<String> generateParenthesisDFS(int n) {
    List<String> ans = new ArrayList<>();
    if (n == 0) {
      return ans;
    }

    dfs("", n, n, ans);
    return ans;
  }

  private void dfs(String curStr, int left, int right, List<String> ans) {
    if (left == 0 && right == 0) {
      ans.add(curStr);
      return;
    }

    if (left > right) {
      return;
    }

    if (left > 0) {
      dfs(curStr + "(", left - 1, right, ans);
    }

    if (right > 0) {
      dfs(curStr + " )", left, right - 1, ans);
    }
  }

  private void generateAll(char[] current, int pos, List<String> ans) {
    if (pos == current.length) {
      if (valid(current)) {
        ans.add(new String(current));
      }
    } else {
      current[pos] = '(';
      generateAll(current, pos + 1, ans);
      current[pos] = ')';
      generateAll(current, pos + 1, ans);
    }
  }

  private boolean valid(char[] current) {
    int balance = 0;
    for (char c : current) {
      if (c == '(') {
        ++balance;
      } else {
        --balance;
      }
      if (balance < 0) {
        return false;
      }
    }
    return balance == 0;
  }

}
