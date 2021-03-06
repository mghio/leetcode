package cn.mghio.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角
 *
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * @author mghio
 * @since 2021-04-12
 */
public class PascalTriangle {

  public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> rowItems = new ArrayList<>();
    if (numRows == 1) {
      rowItems.add(1);
      result.add(rowItems);
      return result;
    }

    for (int i = 1; i <= numRows; i++) {
      rowItems = new ArrayList<>();
      for (int j = 0; j <= i - 1; j++) {
        if (j == 0 || j == i - 1) {
          rowItems.add(1);
        } else {
          List<Integer> rowValues = result.get(i - 2);
          Integer leftVal = rowValues.get(j - 1);
          Integer rightVal = rowValues.get(j);
          rowItems.add(leftVal + rightVal);
        }
      }
      result.add(rowItems);
    }

    return result;
  }

}
