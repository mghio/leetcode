package cn.mghio.leetcode.list;

/**
 * Given the head of a singly linked list and two integers left and right where left <= right,
 * reverse the nodes of the list from position left to position right, and return the reversed
 * list.
 *
 * @author mghio
 * @since 2021-10-14
 */
public class ReverseBetween {

  private SinglyNode successor;

  /**
   * reverse the nodes of the list from position left to position right, and return the reversed
   * list
   *
   * @param head the head node
   * @param m the left position
   * @param n the right position
   * @return the reversed singly-linked list
   */
  public SinglyNode reverseBetween(SinglyNode head, int m, int n) {
    if (m == 1) {
      return reverseN(head, n);
    }

    head.next = reverseBetween(head.next, m - 1, n - 1);
    return head;
  }

  public SinglyNode reverseN(SinglyNode head, int n) {
    if (n == 1) {
      successor = head.next;
      return head;
    }

    SinglyNode last = reverseN(head.next, n - 1);
    head.next.next = head;
    head.next = successor;
    return last;
  }

}
