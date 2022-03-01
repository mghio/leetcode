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
    ListNode p1 = l1;
    ListNode p2 = l2;

    while (p1 != null && p2 != null) {
      if (p1.val < p2.val) {
        p.next = p1;
        p1 = p1.next;
      } else {
        p.next = p2;
        p2 = p2.next;
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

  /**
   * Merge the two lists in a one sorted list. The list should be made by splicing together the
   * nodes of the first two lists.
   *
   * @param l1 the node list
   * @param l2 the other node list
   * @return the result head node
   */
  public ListNode mergeTwoListSolution2(ListNode l1, ListNode l2) {
    if (l1 == null) {
      return l2;
    } else if (l2 == null) {
      return l1;
    } else if (l1.val < l2.val) {
      l1.next = mergeTwoListSolution2(l1.next, l2);
      return l1;
    } else {
      l2.next = mergeTwoListSolution2(l1, l2.next);
      return l2;
    }
  }

}
