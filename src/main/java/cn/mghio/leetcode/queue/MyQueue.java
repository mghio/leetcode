package cn.mghio.leetcode.queue;

import java.util.Stack;

/**
 * Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should
 * support all the functions of a normal queue (push, peek, pop, and empty).
 *
 * @author mghio
 * @since 2021-12-01
 */
public class MyQueue {

  private final Stack<Integer> stack1;

  private final Stack<Integer> stack2;

  public MyQueue() {
    stack1 = new Stack<>();
    stack2 = new Stack<>();
  }

  public void push(int x) {
    while (!stack2.isEmpty()) {
      stack1.push(stack2.pop());
    }

    stack2.push(x);

    while (!stack1.isEmpty()) {
      stack2.push(stack1.pop());
    }
  }

  public int pop() {
    return stack2.pop();
  }

  public int peek() {
    return stack2.peek();
  }

  public boolean empty() {
    return stack2.isEmpty();
  }

}
