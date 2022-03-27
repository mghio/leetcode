package cn.mghio.leetcode.array;

/**
 * Next Permutation.
 *
 * @author mghio
 * @since 2022-03-27
 */
public class NextPermutation {

  public static void main(String[] args) {
    int[] nums = new int[]{1, 2, 3};
    NextPermutation nextPermutation = new NextPermutation();
    nextPermutation.nextPermutation(nums);
  }

  public void nextPermutation(int[] nums) {
    if (nums == null || nums.length == 0) {
      return;
    }

    int i = nums.length - 2;
    while (i >= 0 && nums[i] >= nums[i + 1]) {
      i--;
    }

    if (i >= 0) {
      int j = nums.length - 1;
      while (j >= 0 && nums[i] >= nums[j]) {
        j--;
      }
      swap(nums, i, j);
    }
    reverse(nums, i + 1);
  }

  private void reverse(int[] nums, int start) {
    int l = start, r = nums.length - 1;
    while (l < r) {
      swap(nums, l, r);
      l++;
      r--;
    }
  }

  private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

}
