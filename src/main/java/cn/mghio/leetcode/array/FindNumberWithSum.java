package cn.mghio.leetcode.array;

/**
 * @author mghio
 * @since 2021-10-25
 */
public class FindNumberWithSum {

  /**
   * Given an array, find two element sum equal target.
   *
   * @param nums the array
   * @param target the target
   * @return the index
   */
  public int[] findNumberWithSum(int[] nums, int target) {
    if (nums == null || nums.length < 2) {
      return nums;
    }

    int ahead = nums.length - 1;
    int behind = 0;
    while (ahead > behind) {
      int curSum = nums[ahead] + nums[behind];
      if (curSum == target) {
        return new int[]{nums[behind], nums[ahead]};
      } else if (curSum > target) {
        ahead--;
      } else {
        behind++;
      }
    }
    return new int[]{0, 0};
  }

}
