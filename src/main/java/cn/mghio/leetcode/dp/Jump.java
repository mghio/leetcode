package cn.mghio.leetcode.dp;

/**
 * Given an array of non-negative integers nums, you are initially positioned at the first index of
 * the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Your goal is to reach the last index in the minimum number of jumps.
 *
 * You can assume that you can always reach the last index.
 *
 * @author mghio
 * @since 2021-11-03
 */
public class Jump {

  /**
   * Given an array of non-negative integers nums, you are initially positioned at the first index
   * of the array.
   *
   * @param nums the array
   * @return the num
   */
  public int jump(int[] nums) {
    if (nums == null || nums.length < 1) {
      return -1;
    }

    int maxPos = 0;
    int minJumpCnt = 0;
    int end = 0;
    for (int i = 0; i < nums.length - 1; i++) {
      maxPos = Math.max(maxPos, i + nums[i]);
      if (i == end) {
        end = maxPos;
        ++minJumpCnt;
      }
    }

    return minJumpCnt;
  }

}
