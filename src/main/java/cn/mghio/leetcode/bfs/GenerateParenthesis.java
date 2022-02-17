package cn.mghio.leetcode.bfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed
 * parentheses.
 *
 * @author mghio
 * @since 2022-02-17
 */
public class GenerateParenthesis {

  /**
   * Given n pairs of parentheses, write a function to generate all combinations of well-formed
   * parentheses.
   *
   * @param n the n pairs of parentheses
   * @return the well-formed parentheses
   */
  public List<String> generateParenthesis(int n) {
    if (n <= 0) {
      return new ArrayList<>();
    }

    List<String> res = new ArrayList<>();
    generate(0, 0, res, n, "");
    return res;
  }

  private void generate(int left, int right, List<String> res, int n, String result) {
    if (left == n && right == n) {
      res.add(result);
      return;
    }

    if (left < n) {
      generate(left + 1, right, res, n, result + "(");
    }

    if (left > right && right < n) {
      generate(left, right + 1, res, n, result + ")");
    }
  }

}
