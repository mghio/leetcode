package cn.mghio.leetcode.array;

/**
 * 给定一个增序排列数组 nums ，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。 不要使用额外的数组空间，你必须在原地修改输入数组 并在使用 O(1)
 * 额外空间的条件下完成。
 *
 * @author mghio
 * @since 2021-03-28
 */
public class RemoveDuplicates {

  /**
   * 思路：改变 len < n || nums[i] != nums[len - n] 中 n 的值可适用于保留 n 重复项题目
   */
  public int removeDuplicates(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    // 注意一点: 遍历的时候只需要不和前面的第二个数相等就行
    int k = 0;
    for (int i = 0; i < nums.length; i++) {
      // 注意: 这里是当前元素和新数组的往前第二个元素不相等
      if (k < 2 || nums[i] != nums[k - 2]) {
        nums[k++] = nums[i];
      }
    }

    return k;
  }

}
