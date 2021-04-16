package cn.mghio.leetcode.array;

/**
 * 已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。例如，
 * 原数组 nums = [0,1,2,4,5,6,7] 在变化后可能得到：
 * 若旋转 4 次，则可以得到 [4,5,6,7,0,1,2]
 * 若旋转 7 次，则可以得到 [0,1,2,4,5,6,7]
 * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
 * 给你一个元素值 互不相同 的数组 nums，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的最小元素 。
 *
 * 提示：
 * n == nums.length
 * 1 <= n <= 5000
 * -5000 <= nums[i] <= 5000
 * nums 中的所有整数 互不相同，nums 原来是一个升序排序的数组，并进行了 1 至 n 次旋转
 *
 * @author mghio
 * @since 2021-04-15
 */
public class FindMin {

  public int findMin(int[] nums) {
    // 方法一：暴力解法
//    int result = violenceSolution(nums);

    // 方法二：双指针解法
    int result = doublePoint(nums);

    return result;
  }

  /**
   * 方法二：双指针解法
   */
  private int doublePoint(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    int low = 0;
    int high = nums.length - 1;
    int mid = low;  // 这里赋值的原因是特例：把排序数组前面的 0 个元素搬到最后面，即数组本身，这也是一种旋转
    while (nums[low] >= nums[high]) {
      if (high - low == 1) {
        mid = high;
        break;
      }

      mid = (high - low) / 2 + low;
      if (nums[low] >= nums[high]) {
        low = mid;
      } else if (nums[low] <= nums[high]) {
        high = mid;
      }
    }

    return nums[mid];
  }

  /**
   * 方法一：暴力解法
   * 时间复杂度：O(n)
   */
  private int violenceSolution(int[] nums) {
    int min = nums[0];
    for (int i = 1; i < nums.length; i++) {
      if (min > nums[i]) {
        min = nums[i];
      }
    }
    return min;
  }

}
