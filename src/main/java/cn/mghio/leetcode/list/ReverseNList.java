package java.cn.mghio.leetcode.list;

/**
 * Given N, reverse N first node, then return the head node.
 *
 * @author mghio
 * @since 2021-10-14
 */
public class ReverseNList {

  private SinglyNode successor;

  /**
   * Reverse N singly-linked list.
   *
   * @param head the head node
   * @param n the reverse N node
   * @return the reversed head node
   */
  public SinglyNode reverseNList(SinglyNode head, int n) {
    if (n == 1) {
      successor = head.next;
      return head;
    }

    SinglyNode last = reverseNList(head.next, n - 1);
    head.next.next = head;
    head.next = successor;
    return last;
  }

}
