package java.cn.mghio.leetcode.array;

/**
 * There is a number in the array that appears more than half the length of the array. Please find
 * out this number.
 *
 * @author mghio
 * @since 2021-10-06
 */
public class MajorityElement {

  /**
   * Find the majority element in array.
   *
   * @param nums the array
   * @return the majority element
   */
  public int majorityElement(int[] nums) {
    if (nums == null || nums.length < 1) {
      return 0;
    }

    int ret = nums[0];
    int times = 1;
    for (int i = 1; i < nums.length; i++) {
      if (times == 0) {
        ret = nums[i];
        times = 1;
      } else if (ret == nums[i]) {
        times++;
      } else {
        times--;
      }
    }

    if (!checkMoreThanHalf(nums, ret)) {
      ret = 0;
    }

    return ret;
  }

  private boolean checkMoreThanHalf(int[] nums, int number) {
    int times = 0;
    for (int num : nums) {
      if (num == number) {
        times++;
      }
    }

    return times * 2 > nums.length;
  }

}
