package cn.mghio.leetcode.array;

/**
 * 给定一个二进制数组， 计算其中最大连续 1 的个数。
 *
 * @author mghio
 * @since 2021-04-10
 */
public class FindMaxConsecutiveOnes {

  public int findMaxConsecutiveOnes(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    int maxCount = 0;
    int curCount = 0;
    for (int num : nums) {
      if (num == 1) {
        curCount++;
      } else {
        maxCount = Math.max(maxCount, curCount);
        curCount = 0;
      }
    }

    // note: 遍历数组结束之后，需要再次使用当前的连续 11 的个数更新最大的连续 11 的个数，
    // 因为数组的最后一个元素可能是 11，且最长连续 11 的子数组可能出现在数组的末尾，
    // 如果遍历数组结束之后不更新最大的连续 11 的个数，则会导致结果错误。
    return Math.max(maxCount, curCount);
  }

}
