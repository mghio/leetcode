package cn.mghio.leetcode.queue;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author mghio
 * @since 2022-03-30
 */
public class CustomArrayBlockingQueue<E> {

  private final ReentrantLock lock;

  /**
   * Condition for waiting takes
   */
  private final Condition notEmpty;

  /**
   * Condition for waiting puts
   */
  private final Condition notFull;

  private final Object[] items;

  private int count;

  private int takeIndex;

  private int putIndex;

  public CustomArrayBlockingQueue(int capacity, boolean fair) {
    if (capacity < 0) {
      throw new IllegalArgumentException();
    }

    this.lock = new ReentrantLock(fair);
    this.notEmpty = lock.newCondition();
    this.notFull = lock.newCondition();
    this.items = new Object[capacity];
  }

  public E take() throws InterruptedException {
    final ReentrantLock lock = this.lock;
    lock.lockInterruptibly();
    try {
      while (count == 0) {
        notEmpty.await();
      }
      return dequeue();
    } finally {
      lock.unlock();
    }
  }

  public void add(E e) throws InterruptedException {
    final ReentrantLock lock = this.lock;
    lock.lockInterruptibly();
    try {
      while (count == items.length) {
        notFull.await();
      }
      enqueue(e);
    } finally {
      lock.unlock();
    }
  }

  private void enqueue(E e) {
    assert lock.isHeldByCurrentThread();
    assert lock.getHoldCount() == 1;
    assert items[putIndex] == null;

    final Object[] items = this.items;
    items[putIndex] = e;
    if (++putIndex == items.length) {
      putIndex = 0;
    }
    count++;
    notEmpty.signal();
  }

  private E dequeue() {
    final Object[] items = this.items;
    @SuppressWarnings("unchecked")
    E e = (E) items[takeIndex];
    if (--putIndex < 0) {
      putIndex = 0;
    }
    count++;
    notFull.signal();
    return e;
  }
}
