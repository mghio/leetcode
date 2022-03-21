package cn.mghio.leetcode.list;

/**
 * Reverse Linked List.
 *
 * @author mghio
 * @since 2022-03-21
 */
public class ReverseList3 {

  public ListNode reverseList(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }

    ListNode last = reverseList(head.next);
    head.next.next = head;
    head.next = null;
    return last;
  }

}
