package cn.mghio.leetcode.list;

/**
 * Reverse Nodes in k-Group.
 *
 * @author mghio
 * @since 2022-04-09
 */
public class ReverseKGroup {

  public ListNode reverseKGroup(ListNode head, int k) {
    if (head == null) {
      return null;
    }

    ListNode begin = head, end = head;
    for (int i = 0; i < k; i++) {
      if (end == null) {
        return head;
      }
      end = end.next;
    }

    ListNode newHead = reverse(begin, end);
    begin.next = reverseKGroup(end, k);
    return newHead;
  }

  /**
   * invert the elements of the interval [a, b).
   */
  private ListNode reverse(ListNode begin, ListNode end) {
    ListNode pre = null, cur = begin, next;
    while (cur != end) {
      next = cur.next;
      cur.next = pre;
      pre = cur;
      cur = next;
    }
    return pre;
  }

}
