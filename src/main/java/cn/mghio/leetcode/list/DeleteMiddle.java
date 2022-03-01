package cn.mghio.leetcode.list;

/**
 * You are given the head of a linked list. Delete the middle node, and return the head of the
 * modified linked list.
 *
 * @author mghio
 * @since 2022-03-01
 */
public class DeleteMiddle {

  public ListNode deleteMiddle(ListNode head) {
    if (head == null || head.next == null) {
      return null;
    }

    ListNode slow = head;
    ListNode fast = head;
    ListNode pre = head;
    while (fast != null && fast.next != null) {
      pre = slow;
      slow = slow.next;
      fast = fast.next.next;
    }

    pre.next = pre.next.next;
    slow.next = null;
    return head;
  }

}
