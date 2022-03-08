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
    SinglyNode first = head;
    for (int i = 0; i < n; i++) {
      first = first.next;
    }

    SinglyNode dummy = new SinglyNode(-1, head);
    SinglyNode second = dummy;
    while (first != null) {
      first = first.next;
      second = second.next;
    }

    second.next = second.next.next;
    return dummy.next;
  }

  /**
   * remove the nth node from the end of the list and return its.
   *
   * @param head the head of singly-linked list.
   * @param n the n th
   * @return the nth node from the end of list
   */
  public SinglyNode removeNthFromEndSolution2(SinglyNode head, int n) {
    SinglyNode dummy = new SinglyNode(-1, head);
    int length = getLength(head);
    SinglyNode curr = dummy;
    for (int i = 1; i < length - n + 1; i++) {
      curr = curr.next;
    }
    curr.next = curr.next.next;
    return dummy.next;
  }

  private int getLength(SinglyNode head) {
    int length = 0;
    while (head != null) {
      length++;
      head = head.next;
    }
    return length;
  }

}
