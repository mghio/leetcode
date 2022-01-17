package cn.mghio.leetcode.list;

/**
 * You are given the heads of two sorted linked lists list1 and list2.
 *
 * Merge the two lists in a one sorted list. The list should be made by splicing together the nodes
 * of the first two lists.
 *
 * Return the head of the merged linked list.
 *
 * @author mghio
 * @since 2022-01-17
 */
public class MergeTwoList {

  /**
   * Merge the two lists in a one sorted list. The list should be made by splicing together the
   * nodes of the first two lists.
   *
   * @param l1 the node list
   * @param l2 the other node list
   * @return the result head node
   */
  public ListNode mergeTwoList(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(-1);
    ListNode p = dummy;
    ListNode p1 = l1, p2 = l2;

    while (p1 != null && p2 != null) {
      if (p1.val > p2.val) {
        p.next = p2;
        p2 = p2.next;
      } else {
        p.next = p1;
        p1 = p1.next;
      }
      p = p.next;
    }

    if (p1 != null) {
      p.next = p1;
    }

    if (p2 != null) {
      p.next = p2;
    }

    return dummy.next;
  }

}
