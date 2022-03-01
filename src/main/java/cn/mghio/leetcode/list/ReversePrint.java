package cn.mghio.leetcode.list;

import java.util.Stack;

/**
 * Enter the head node of a linked list, and return the value of each node (returned as an array)
 * from the end to the beginning.
 *
 * @author mghio
 * @since 2022-03-01
 */
public class ReversePrint {

  public int[] reversePrint(ListNode head) {
    if (head == null) {
      return new int[]{};
    }

    Stack<ListNode> stack = new Stack<>();
    ListNode tmp = head;
    while (tmp != null) {
      stack.push(tmp);
      tmp = tmp.next;
    }

    int n = stack.size();
    int[] res = new int[n];
    for (int i = 0; i < n; i++) {
      res[i] = stack.pop().val;
    }

    return res;
  }

}
