package cn.mghio.leetcode.queue;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Design a limited blocking queue.
 *
 * @author mghio
 * @since 2021-11-22
 */
public class BoundedBlockingQueue<T> {

  /**
   * The max queue capacity
   */
  private final int capacity;

  private final List<T> queue = new LinkedList<>();
  private final ReentrantLock lock = new ReentrantLock();
  private final Condition notFull = lock.newCondition();
  private final Condition notEmpty = lock.newCondition();

  public BoundedBlockingQueue(int capacity) {
    this.capacity = capacity;
  }

  /**
   * Add an element at the head of the queue.
   * If the queue is full, the calling thread is blocked until the queue is not full.
   *
   * @param element the element to add
   */
  public void enqueue(T element) throws InterruptedException {
    lock.lock();
    try {
      while (queue.size() == capacity) {
        // 等待队列不满
        notFull.await();
      }
      queue.add(element);
      // 入队后，通知可出队
      notEmpty.signal();
    } finally {
      lock.unlock();
    }
  }

  /**
   * Return the tail element and delete it from the queue.
   * If the queue is empty, the calling thread is blocked until the queue is not empty.
   *
   * @return the dequeue element
   */
  public T dequeue() throws InterruptedException {
    T t;
    lock.lock();
    try {
      while (queue.size() == 0) {
        // 等待队列不空
        notEmpty.await();
      }
      t = queue.remove(queue.size() - 1);
      // 出队后，通知可入队
      notFull.signal();
    } finally {
      lock.unlock();
    }
    return t;
  }

}
