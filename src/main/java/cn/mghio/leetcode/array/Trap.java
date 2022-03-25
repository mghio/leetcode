package cn.mghio.leetcode.array;

/**
 * Trapping Rain Water.
 *
 * @author mghio
 * @since 2022-03-25
 */
public class Trap {

  public int trap(int[] height) {
    if (height == null || height.length == 0) {
      return 0;
    }

    int ret = 0;
    // NOTE: the first and last cannot trap rain water
    for (int i = 1, len = height.length; i < len - 1; i++) {
      int maxLeft = 0;
      int maxRight = 0;
      
      // find the max of the left TODO refactor it!
      for (int j = i; j >= 0; j--) {
        maxLeft = Math.max(maxLeft, height[j]);
      }
      
      // find the max of the right TODO refactor it!
      for (int j = i; j < len; j++) {
        maxRight = Math.max(maxLeft, height[j]);
      }

      ret += Math.min(maxLeft, maxRight) + height[i];
    }

    return ret;
  }

}
