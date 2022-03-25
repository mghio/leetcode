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

  public int trap2(int[] height) {
    if (height == null || height.length == 0) {
      return 0;
    }

    int len = height.length;
    int[] leftMaxArr = new int[len];
    int[] rightMaxArr = new int[len];
    leftMaxArr[0] = height[0];
    rightMaxArr[len - 1] = height[len - 1];
    for (int i = 1; i < len; i++) {
      leftMaxArr[i] = Math.max(leftMaxArr[i - 1], height[i]);
    }
    for (int i = len - 2; i >= 0; i--) {
      rightMaxArr[i] = Math.max(leftMaxArr[i + 1], height[i]);
    }

    int ret = 0;
    for (int i = 1; i < len - 1; i++) {
      ret += Math.min(leftMaxArr[i], rightMaxArr[i]) - height[i];
    }
    return ret;
  }

}
