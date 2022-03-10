package cn.mghio.leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Give you an array T, which stores the weather and temperature in recent days, you return an array
 * of equal length, and calculate: for each day, how many days do you have to wait to get a warmer
 * temperature; if you can't wait On that day, fill in 0.
 *
 * @author mghio
 * @since 2022-03-10
 */
public class DailyTemperatures {

  public int[] dailyTemperatures(int[] days) {
    if (days == null || days.length == 0) {
      return new int[]{};
    }

    int[] res = new int[days.length];
    Deque<Integer> stack = new ArrayDeque<>();
    for (int i = days.length - 1; i >= 0; i--) {
      while (!stack.isEmpty() && days[i] > stack.peek()) {
        stack.pop();
      }
      res[i] = stack.isEmpty() ? 0 : (stack.peek() - i);
      stack.push(i);
    }

    return res;
  }

}
