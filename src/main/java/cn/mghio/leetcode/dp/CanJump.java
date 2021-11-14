package cn.mghio.leetcode.dp;

/**
 * You are given an integer array nums. You are initially positioned at the array's first index, and
 * each element in the array represents your maximum jump length at that position.
 *
 * Return true if you can reach the last index, or false otherwise.
 *
 * @author mghio
 * @since 2021-11-02
 */
public class CanJump {

  /**
   * Each element in the array represents your maximum jump length at that position.
   *
   * @param nums the array
   * @return return true if you can reach the last index, or false otherwise
   */
  public boolean canJumpSolution1(int[] nums) {
    if (nums == null || nums.length < 1) {
      return false;
    }

    int maxDistance = 0;
    for (int i = 0; i < nums.length; i++) {
      if (i > maxDistance) {
        return false;
      }
      maxDistance = Math.max(maxDistance, i + nums[i]);
    }
    return true;
  }

  /**
   * Each element in the array represents your maximum jump length at that position.
   *
   * @param nums the array
   * @return return true if you can reach the last index, or false otherwise
   */
  public boolean canJumpSolution2(int[] nums) {
    int n = nums.length;
    int rightMost = 0;
    for (int i = 0; i < n; i++) {
      if (i <= rightMost) {
        rightMost = Math.max(rightMost, i + nums[i]);
        if (rightMost >= n - 1) {
          return true;
        }
      }
    }
    return false;
  }

}
