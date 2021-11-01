package java.cn.mghio.leetcode.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string expression of numbers and operators, return all possible results from computing
 * all the different possible ways to group numbers and operators. You may return the answer in any
 * order.
 *
 * @author mghio
 * @since 2021-11-01
 */
public class DiffWaysToCompute {

  /**
   * Find all possible results from computing all the different possible ways to group numbers and
   * operators.
   *
   * @param expression the expression
   * @return the result
   */
  public List<Integer> diffWaysToCompute(String expression) {
    return divideAndConquer(expression.toCharArray());
  }

  private List<Integer> divideAndConquer(char[] expression) {
    List<Integer> ans = new ArrayList<>();

    if (isOneNum(expression)) {
      int num = 0;
      for (char c : expression) {
        num = num * 10 + c - '0';
      }
      ans.add(num);
      return ans;
    }

    for (int i = 0; i < expression.length; i++) {
      if (!Character.isDigit(expression[i])) {
        char[] left = new char[i];
        char[] right = new char[expression.length - i - 1];

        System.arraycopy(expression, 0, left, 0 , i);
        System.arraycopy(expression, i + 1, right, 0, expression.length - i - 1);

        List<Integer> leftList = divideAndConquer(left);
        List<Integer> rightList = divideAndConquer(right);

        List<Integer> tempRes = calculate(leftList, rightList, expression[i]);
        ans.addAll(tempRes);
      }
    }
    return ans;
  }

  private List<Integer> calculate(List<Integer> leftList, List<Integer> rightList, char operator) {
    List<Integer> ans = new ArrayList<>();
    for (Integer left : leftList) {
      for (Integer right : rightList) {
        ans.add(calculateTwoNums(left, right, operator));
      }
    }
    return ans;
  }

  private Integer calculateTwoNums(Integer left, Integer right, char operator) {
    switch (operator) {
      case '+':
        return left + right;
      case '-':
        return left - right;
      default:
        return left * right;
    }
  }

  private boolean isOneNum(char[] expression) {
    for (char c : expression) {
      if (!Character.isDigit(c)) {
        return false;
      }
    }
    return true;
  }

}
