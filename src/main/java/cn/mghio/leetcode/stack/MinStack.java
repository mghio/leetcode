package cn.mghio.leetcode.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant
 * time.
 *
 * @author mghio
 * @since 2022-03-04
 */
public class MinStack {

  private Deque<Integer> xStack;
  private Deque<Integer> minStack;

  public MinStack() {
    xStack = new LinkedList<>();
    minStack = new LinkedList<>();
    minStack.push(Integer.MAX_VALUE);
  }

  public void push(int val) {
    xStack.push(val);
    minStack.push(Math.min(minStack.peek(), val));
  }

  public void pop() {
    xStack.pop();
    minStack.pop();
  }

  public int top() {
    return xStack.peek();
  }

  public int getMin() {
    return minStack.peek();
  }

}
