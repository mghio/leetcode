package cn.mghio.leetcode.array;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it can trap after raining.
 *
 * @author mghio
 * @since 2021-11-22
 */
public class TrappingRainWater {

  /**
   * Return how much water it can trap after raining.
   *
   *
   *
   * @param height the elevation map
   * @return the trap after raining
   */
  public int trapSolution1(int[] height) {
    if (height == null || height.length < 2) {
      return 0;
    }

    int n = height.length;
    int ans = 0;
    for (int i = 1; i < n - 1; i++) {
      int leftMax = 0;
      int rightMax = 0;

      for (int j = i; j >= 0; j--) {
        leftMax = Math.max(leftMax, height[j]);
      }

      for (int j = i; j < n; j++) {
        rightMax = Math.max(rightMax, height[j]);
      }

      ans += Math.min(leftMax, rightMax) - height[i];
    }

    return ans;
  }

  /**
   * Return how much water it can trap after raining.
   *
   * @param height the elevation map
   * @return the trap after raining
   */
  public int trapSolution2(int[] height) {
    if (height.length == 0) {
      return 0;
    }
    int n = height.length;
    int left = 0, right = n - 1;
    int res = 0;

    int l_max = height[0];
    int r_max = height[n - 1];

    while (left <= right) {
      l_max = Math.max(l_max, height[left]);
      r_max = Math.max(r_max, height[right]);

      // res += min(l_max, r_max) - height[i]
      if (l_max < r_max) {
        res += l_max - height[left];
        left++;
      } else {
        res += r_max - height[right];
        right--;
      }
    }

    return res;
  }

}
