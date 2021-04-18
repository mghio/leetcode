package cn.mghio.leetcode.linkedlist;

import java.util.Stack;

/**
 * 输入一个链表的头节点，从尾到头发过来打印出每个节点的值。
 *
 * @author mghio
 * @since 2021-04-18
 */
public class PrintSingleListReverse {

  public void printSingleListReverse(SingleListNode node) {
    if (node == null) {
      return;
    }

    Stack<SingleListNode> stack = new Stack<>();
    while (node != null) {
      stack.push(node);
      node = node.getNext();
    }

    while (!stack.empty()) {
      SingleListNode curNode = stack.pop();
      System.out.printf("%d\t", curNode.getValue());
    }
  }

}
