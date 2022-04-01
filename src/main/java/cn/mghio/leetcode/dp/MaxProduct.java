package cn.mghio.leetcode.dp;

/**
 * Maximum Product Subarray.
 *
 * @author mghio
 * @since 2022-04-01
 */
public class MaxProduct {

  public int maxProduct(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    int len = nums.length;
    int[] max = new int[len];
    int[] min = new int[len];
    max[0] = nums[0];
    min[0] = nums[0];

    for (int i = 1; i < len; i++) {
      max[i] = max(max[i - 1] * nums[i], min[i] * nums[i], nums[i]);
      min[i] = min(min[i - 1] * nums[i], min[i] * nums[i], nums[i]);
    }

    int ret = max[0];
    for (int i = 1; i < len; i++) {
      ret = Math.max(max[i], ret);
    }
    return ret;
  }

  private int maxProduct2(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    int max = nums[0];
    int min = nums[0];
    int ret = nums[0];

    for (int i = 1, len = nums.length; i < len; i++) {
      int tempMax = max;
      int tempMin = min;
      int curNum = nums[i];
      max = max(tempMin * curNum, tempMax * curNum, curNum);
      min = min(tempMin * curNum, tempMax * curNum, curNum);
      ret = Math.max(max, ret);
    }
    return ret;
  }

  private int max(int a, int b, int c) {
    return Math.max(a, Math.max(b, c));
  }

  private int min(int a, int b, int c) {
    return Math.min(a, Math.min(b, c));
  }

}
