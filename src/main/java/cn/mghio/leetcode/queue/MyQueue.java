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

  private Stack<Integer> s1;
  private Stack<Integer> s2;

  public MyQueue() {
    s1 = new Stack<>();
    s2 = new Stack<>();
  }

  public void push(int item) {
    s1.push(item);
  }

  public int pop() {
    peek();
    return s2.pop();
  }

  public int peek() {
    if (s2.isEmpty()) {
      while (!s1.isEmpty()) {
        s2.push(s1.pop());
      }
    }
    return s2.peek();
  }

  public boolean empty() {
    return s1.isEmpty() && s2.isEmpty();
  }

}
