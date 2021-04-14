package cn.mghio.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角 II
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * @author mghio
 * @since 2021-04-12
 */
public class PascalTriangle2 {

  public List<Integer> getRow(int rowIndex) {
    List<List<Integer>> triangle = new ArrayList<>();
    for (int i = 0; i <= rowIndex; i++) {
      List<Integer> row = new ArrayList<>();
      for (int j = 0; j <= i; j++) {
        if (j == 0 || j == i) {
          row.add(1);
        } else {
          row.add(triangle.get(i - 1).get(j - 1) + triangle.get(i- 1).get(j));
        }
      }
      triangle.add(row);
    }
    return triangle.get(rowIndex);
  }

}
