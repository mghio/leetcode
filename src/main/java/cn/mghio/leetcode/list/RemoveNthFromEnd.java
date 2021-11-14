package cn.mghio.leetcode.list;

/**
 * Given the head of a linked list, remove the nth node from the end of the list and return its.
 * head.
 *
 * @author mghio
 * @since 2021-10-11
 */
public class RemoveNthFromEnd {

  /**
   * remove the nth node from the end of the list and return its.
   *
   * @param head the head of singly-linked list.
   * @param n the n th
   * @return the nth node from the end of list
   */
  public SinglyNode removeNthFromEnd(SinglyNode head, int n) {
    SinglyNode dummy = new SinglyNode(-1, head);
    SinglyNode first = head;
    SinglyNode second = dummy;
    for (int i = 0; i < n; i++) {
      first = first.next;
    }
    while (first != null) {
      first = first.next;
      second = second.next;
    }
    // delete nth node
    second.next = second.next.next;
    return dummy.next;
  }

}
