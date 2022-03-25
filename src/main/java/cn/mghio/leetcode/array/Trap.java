package cn.mghio.leetcode.array;

import java.util.Deque;
import java.util.LinkedList;

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

  public int trap3(int[] height) {
    if (height == null || height.length == 0) {
      return 0;
    }

    int len = height.length;
    int leftIndex = 0, rightIndex = len - 1;
    int leftMax = height[0], rightMax = height[len - 1];
    int ret = 0;

    while (leftIndex <= rightIndex) {
      leftMax = Math.max(leftMax, height[leftIndex]);
      rightMax = Math.max(rightMax, height[rightIndex]);

      if (leftMax < rightMax) {
        ret += leftMax - height[leftIndex];
        leftIndex++;
      } else {
        ret += rightMax - height[rightIndex];
        rightIndex--;
      }
    }
    return ret;
  }

  public int trap4(int[] height) {
    if (height == null || height.length == 0) {
      return 0;
    }

    int len = height.length;
    int ret = 0, curPos = 0;
    // min heap
    Deque<Integer> stack = new LinkedList<>();
    while (curPos < len) {
      while (!stack.isEmpty() && height[curPos] > height[stack.peek()]) {
        int top = stack.pop();
        if (stack.isEmpty()) {
          break;
        }
        int distance = curPos - stack.peek() - 1;
        int bounded_height = Math.min(height[curPos], height[stack.peek()]) - height[top];
        ret += distance * bounded_height;
      }
      stack.push(curPos++);
    }
    return ret;
  }

}
