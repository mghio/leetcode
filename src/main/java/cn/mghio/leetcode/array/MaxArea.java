package cn.mghio.leetcode.array;

/**
 * Container With Most Water.
 *
 * @author mghio
 * @since 2022-03-24
 */
public class MaxArea {

  public int maxArea(int[] height) {
    if (height == null || height.length == 0) {
      return 0;
    }

    int ret = 0;
    for (int i = 0, len = height.length; i < len; i++) {
      for (int j = i + 1; j < len; j++) {
        int curArea = (j - i) * Math.min(height[i], height[j]);
        ret = Math.max(ret, curArea);
      }
    }
    return ret;
  }

  // double point
  public int maxArea2(int[] height) {
    if (height == null || height.length == 0) {
      return 0;
    }

    int startIndex = 0;
    int endIndex = height.length - 1;
    int ret = 0;
    while (startIndex < endIndex) {
      int startHeight = height[startIndex];
      int endHeight = height[endIndex];
      int curArea = (endIndex - startIndex) * Math.min(startHeight, endHeight);
      ret = Math.max(ret, curArea);

      if (startHeight <= endHeight) {
        startIndex++;
      } else {
        endIndex--;
      }
    }

    return ret;
  }

}
