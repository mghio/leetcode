package cn.mghio.leetcode.array;

/**
 * 移除元素。给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地修改输入数组。元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 * @author mghio
 * @since 2021-04-09
 */
public class RemoveElement {

  public int removeElement(int[] nums, int target) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    // 方法一：双指针
//    int slow = solution1(nums, target);

    // 方法二：双指针 —— 当要删除的元素很少时
    int slow = solution2(nums, target);

    return slow;
  }

  /**
   * 方法二：双指针 —— 当要删除的元素很少时
   */
  private int solution2(int[] nums, int target) {
    int i = 0;
    int n = nums.length;
    while (i < n) {
      if (nums[i] == target) {
        nums[i] = nums[n - 1];
        nums[n - 1] = target;
        n--;
      } else {
        i++;
      }
    }
    return n;
  }

  /**
   * 方法一：双指针
   */
  private int solution1(int[] nums, int target) {
    int slow = 0, fast = 0;
    for (fast = 0; fast < nums.length; fast++) {
      if (nums[fast] != target) {
        nums[slow++] = nums[fast];
      }
    }

    for (int i = slow; i < nums.length; i++) {
      nums[i] = target;
    }
    return slow;
  }

}
