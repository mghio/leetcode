package cn.mghio.leetcode.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given a matrix of M x N elements (M rows, N columns), return all elements of the matrix in
 * diagonal order as shown in the below image.
 *
 * @author mghio
 * @since 2021-03-15
 */
public class DiagonalOrder {

  /**
   * 1. 初始化数组 result，用于存储最后结果。
   * 2. 使用一个外层循环遍历所有的对角线。第一行和最后一列的元素都是对角线的起点。
   * 3. 使用一个内层 while 循环遍历对角线上的所有元素。可以计算指定对角线上的元素数量，
   *    也可以简单迭代直到索引超出范围。因为不知道每条对角线上的元素数量，需要为每条对角线分配一个列表或动态数组。
   *    但是同样也可以通过计算得到当前对角线上的元素数量。
   * 4. 对于奇数编号的对角线，只需要将迭代结果翻转再加入结果数组即可。
   */
  public int[] solution1(int[][] matrix) {
    if (matrix == null || matrix.length == 0) {
      return new int[0];
    }

    int rowNumber = matrix.length;
    int colNumber = matrix[0].length;

    int[] result = new int[rowNumber * colNumber];
    int k = 0;
    List<Integer> intermediate = new ArrayList<>();

    for (int i = 0; i < rowNumber + colNumber - 1; i++) {
      intermediate.clear();
      int rowIndex = i < colNumber ? 0 : i - colNumber + 1;
      int colIndex = i < colNumber ? i : colNumber - 1;
      while (rowIndex < rowNumber && colIndex > -1) {
        intermediate.add(matrix[rowIndex][colIndex]);
        ++rowIndex;
        --colIndex;
      }
      if (i % 2 == 0) {
        Collections.reverse(intermediate);
      }
      for (Integer integer : intermediate) {
        result[k++] = integer;
      }
    }
    return result;
  }

}
