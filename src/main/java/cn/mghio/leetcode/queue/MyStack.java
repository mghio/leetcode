package cn.mghio.leetcode.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Implement a last-in-first-out (LIFO) stack using only two queues. The implemented stack should
 * support all the functions of a normal stack (push, top, pop, and empty).
 *
 * @author mghio
 * @since 2022-02-28
 */
public class MyStack {

  private Queue<Integer> queue;

  public MyStack() {
    queue = new LinkedList<>();
  }

  public void push(int item) {
    int size = queue.size();
    queue.offer(item);
    for (int i = 0; i < size; i++) {
      queue.offer(queue.poll());
    }
  }

  public int pop() {
    return queue.poll();
  }

  public int top() {
    return queue.peek();
  }

  public boolean empty() {
    return queue.isEmpty();
  }

}
