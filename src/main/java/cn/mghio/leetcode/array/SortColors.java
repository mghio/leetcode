package cn.mghio.leetcode.array;

/**
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻， 并按照红色、白色、蓝色顺序排列。此题中，我们使用整数 0、1 和 2
 * 分别表示红色、白色和蓝色。
 *
 * @author mghio
 * @since 2021-03-28
 */
public class SortColors {

  public void sortColors(int[] nums) {
    if (nums == null || nums.length == 0) {
      return;
    }

//    sortColor1(nums);

    int low = 0, mid = 0, high = nums.length - 1;
    while (mid <= high) {
      switch (nums[mid]) {
        case 0:
          swapWithTempVariable(nums, low, mid);
          low++;
          mid++;
          break;
        case 1:
          mid++;
          break;
        case 2:
          swapWithTempVariable(nums, mid, high);
          high--;
          break;
        default:
          break;
      }
    }
  }

  /**
   * TODO 交换算法空间复杂度高
   */
  private void swapWithTempVariable(int[] nums, int sourceIndex, int targetIndex) {
    int temp = nums[targetIndex];
    nums[targetIndex] = nums[sourceIndex];
    nums[sourceIndex] = temp;
  }

  /**
   * 相当于遍历了两次，时间复杂度高
   */
  private void sortColor1(int[] nums) {
    int zeroNum = 0, oneNum = 0, twoNum = 0;
    for (int num : nums) {
      switch (num) {
        case 0:
          zeroNum++;
          break;
        case 1:
          oneNum++;
          break;
        case 2:
          twoNum++;
          break;
        default:
          break;
      }
    }

    for (int i = 0; i < zeroNum; i++) {
      nums[i] = 0;
    }

    for (int i = 0; i < oneNum; i++) {
      nums[zeroNum + i] = 1;
    }

    for (int i = 0; i < twoNum; i++) {
      nums[zeroNum + oneNum + i] = 2;
    }
  }

}
