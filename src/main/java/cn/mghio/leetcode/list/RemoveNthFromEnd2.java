package java.cn.mghio.leetcode.list;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author mghio
 * @since 2021-11-13
 */
public class RemoveNthFromEnd2 {

  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode dummy = new ListNode(-1, head);
    ListNode first = head;
    ListNode second = dummy;

    for (int i = 0; i < n; i++) {
      first = first.next;
    }

    while (first != null) {
      first = first.next;
      second = second.next;
    }

    // delete node
    second.next = second.next.next;
    return dummy.next;
  }

  public ListNode removeNthFromEnd2(ListNode head, int n) {
    ListNode dummy = new ListNode(-1, head);
    ListNode cur = dummy;
    int length = getLength(head);

    for (int i = 1; i < length - n + 1; i++) {
      cur = cur.next;
    }

    cur = cur.next;
    return dummy.next;
  }

  public ListNode removeNthFromEnd3(ListNode head, int n) {
    ListNode dummy = new ListNode(-1, head);
    Deque<ListNode> stack = new LinkedList<>();
    ListNode cur = dummy;

    while (cur != null) {
      stack.push(cur);
      cur = cur.next;
    }

    for (int i = 0; i < n; i++) {
      stack.pop();
    }

    ListNode pre = stack.peek();
    pre.next = pre.next.next;
    return dummy.next;
  }

  private int getLength(ListNode head) {
    int length = 0;
    while (head != null) {
      ++length;
      head = head.next;
    }
    return length;
  }

}
