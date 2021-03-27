package cn.mghio.leetcode.array;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例: 输入: [0,1,0,3,12] 输出: [1,3,12,0,0]
 *
 * 说明: 必须在原数组上操作，不能拷贝额外的数组。尽量减少操作次数。
 *
 * @author mghio
 * @since 2021-03-27
 */
public class MoveZero {

  /**
   * 思路：把不是零的元素都重新从头安排，剩下的都填零
   */
  public void moveZeroes(int[] nums) {
    if (nums == null || nums.length == 0) {
      return;
    }

    int index = 0, size = nums.length;
    // Step 1. 把不是零的元素都重新从头安排
    for (int num : nums) {
      if (num != 0) {
        nums[index++] = num;
      }
    }

    // Step 2. 剩下的都填零
    while (index < size) {
      nums[index++] = 0;
    }
  }

}
