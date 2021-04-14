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
    // 方法一：递归
//    List<Integer> result = recursion(rowIndex);

    // 方法二：优化递归（注意到对第 i+1 行的计算仅用到了第 i 行的数据，因此可以使用滚动数组的思想优化空间复杂度。）
//    List<Integer> result = optimizationRecursion(rowIndex);

    // 方法三：优化递归（只用一个 List 倒着计算第 i 行）
    List<Integer> result = optimizationRecursion2(rowIndex);

    return result;
  }

  /**
   * 方法三：优化递归，只用一个数组
   */
  private List<Integer> optimizationRecursion2(int rowIndex) {
    List<Integer> row = new ArrayList<>();
    row.add(1);
    for (int i = 1; i <= rowIndex; i++) {
      row.add(0);
      for (int j = i; j > 0; j--) {
        row.set(j, row.get(j - 1) + row.get(j));
      }
    }
    return row;
  }

  /**
   * 方法二：优化递归
   */
  private List<Integer> optimizationRecursion(int rowIndex) {
    List<Integer> pre = new ArrayList<>();
    for (int i = 0; i <= rowIndex; i++) {
      List<Integer> cur = new ArrayList<>();
      for (int j = 0; j <= i; j++) {
        if (j == 0 || j == i) {
          cur.add(1);
        } else {
          cur.add(pre.get(j - 1) + pre.get(j));
        }
      }
      pre = cur;
    }
    return pre;
  }

  /**
   * 方法一：递归
   */
  private List<Integer> recursion(int rowIndex) {
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
