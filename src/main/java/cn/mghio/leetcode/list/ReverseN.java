package cn.mghio.leetcode.list;

/**
 * Reverse the first N nodes of the linked list.
 *
 * @author mghio
 * @since 2022-04-09
 */
public class ReverseN {

  private ListNode successor = null;

  public ListNode reverseN(ListNode head, int n) {
    if (n == 1) {
      successor = head.next;
      return head;
    }

    ListNode last = reverseN(head.next, n - 1);
    head.next.next = head;
    head.next = successor;
    return last;
  }

}
