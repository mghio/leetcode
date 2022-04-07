package cn.mghio.leetcode.array;

/**
 * Product of Array Except Self.
 *
 * @author mghio
 * @since 2022-04-06
 */
public class ProductExceptSelf {

  public int[] productExceptSelf(int[] nums) {
    if (nums == null || nums.length == 0) {
      return new int[]{};
    }

    int length = nums.length;
    int[] ret = new int[length];
    ret[0] = 1;
    for (int i = 1; i < length; i++) {
      ret[i] = nums[i - 1] * ret[i - 1];
    }

    int r = 1;
    for (int i = length - 1; i >= 0; i--) {
      ret[i] = ret[i] * r;
      r *= nums[i];
    }
    return ret;
  }

  public int[] productExceptSelf2(int[] nums) {
    if (nums == null || nums.length == 0) {
      return new int[]{};
    }

    int len = nums.length;
    int[] leftProduct = new int[len];
    int[] rightProduct = new int[len];

    leftProduct[0] = 1;
    for (int i = 1; i < len; i++) {
      leftProduct[i] = leftProduct[i - 1] * nums[i - 1];
    }

    rightProduct[len - 1] = 1;
    for (int i = len - 2; i >= 0; i--) {
      rightProduct[i] = rightProduct[i + 1] * nums[i + 1];
    }

    int[] ret = new int[len];
    for (int i = 0; i < len; i++) {
      ret[i] = leftProduct[i] * rightProduct[i];
    }

    return ret;
  }

}
