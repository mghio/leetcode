package cn.mghio.leetcode.array;

/**
 * @author mghio
 * @since 2021-12-04
 */
public class TwoSum {

  /**
   * Given an array and target, return two index of sum equals target
   *
   * @param nums the array
   * @param target the target
   * @return the index array
   */
  public int[] twoSum(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;

    while (left < right) {
      int sum = nums[left] + nums[right];

      if (sum == target) {
        return new int[]{left, right};
      } else if (sum < target) {
        left++;
      } else {
        right--;
      }
    }

    return new int[]{-1, -1};
  }

}
