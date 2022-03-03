package cn.mghio.leetcode.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * @author mghio
 * @since 2022-03-03
 */
public class FibonacciRecursiveTask extends RecursiveTask<Integer> {

  private final int n;

  public FibonacciRecursiveTask(int n) {
    this.n = n;
  }

  @Override
  protected Integer compute() {
    if (n <= 1) {
      return n;
    }

    FibonacciRecursiveTask f1 = new FibonacciRecursiveTask(n - 1);
    f1.fork();

    FibonacciRecursiveTask f2 = new FibonacciRecursiveTask(n - 2);
    f2.fork();

    return f2.compute() + f1.compute();
  }

  public static void main(String[] args) {
    ForkJoinPool fjp = new ForkJoinPool(4);
    FibonacciRecursiveTask recursiveTask = new FibonacciRecursiveTask(30);
    Integer result = fjp.invoke(recursiveTask);
    System.out.println(result);
  }

}
