package cn.mghio.leetcode.list;

/**
 * Input a linked list, and output the kth node from the bottom of the linked list. In order to
 * conform to the habits of most people, this question starts counting from 1, that is, the end node
 * of the linked list is the first node from the bottom.
 *
 * @author mghio
 * @since 2021-10-11
 */
public class GetKthFromEnd {

  /**
   * Input a linked list, and output the kth node from the bottom of the linked list.
   *
   * @param head the first node of linked list
   * @param k the k end
   * @return the kth node
   */
  public ListNode getKthFromEnd(ListNode head, int k) {
    ListNode first = head;
    for (int i = 0; i < k; i++) {
      first = first.next;
    }

    ListNode second = head;
    while (first != null) {
      first = first.next;
      second = second.next;
    }

    return second;
  }

  /**
   * Input a linked list, and output the kth node from the bottom of the linked list.
   *
   * @param head the first node of linked list
   * @param k the k end
   * @return the kth node
   */
  public ListNode getKthFromEndSolution2(ListNode head, int k) {
    int n = 0;
    ListNode p;
    for (p = head; p != null; p = p.next) {
      n++;
    }

    for (p = head; n > k; n--) {
      p = p.next;
    }

    return p;
  }

}
