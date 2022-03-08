package cn.mghio.leetcode.list;

/**
 * You are given the heads of two sorted linked lists list1 and list2.
 *
 * Merge the two lists in a one sorted list.
 *
 * The list should be made by splicing together the nodes of the first two lists.
 * Return the head of the merged linked list.
 *
 * @author mghio
 * @since 2022-03-08
 */
public class MergeTwoLists {

  /**
   * Merge the two lists to one sorted list.
   *
   * @param list1 the list node
   * @param list2 the other list node
   * @return the head of the merged linked list
   */
  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    if (list1 == null || list2 == null) {
      return list1 == null ? list2 : list1;
    }

    ListNode dummy = new ListNode(-1);
    ListNode p = dummy;
    ListNode p1 = list1;
    ListNode p2 = list2;

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

}
