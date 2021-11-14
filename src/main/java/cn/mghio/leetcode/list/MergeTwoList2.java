package cn.mghio.leetcode.list;

/**
 * @author mghio
 * @since 2021-11-13
 */
public class MergeTwoList2 {

  public ListNode mergeTwoList(ListNode l1, ListNode l2) {
    if (l1 == null || l2 == null) {
      return l1 == null ? l2 : l1;
    }

    // dummy node
    ListNode dummy = new ListNode(0);
    ListNode tail = dummy;
    ListNode node1 = l1;
    ListNode node2 = l2;

    while (node1 != null && node2 != null) {
      if (node1.val < node2.val) {
        tail.next = node1;
        node1 = node1.next;
      } else {
        tail.next = node2;
        node2 = node2.next;
      }
      tail = tail.next;
    }

    tail.next = node1 == null ? node2 : node1;
    return dummy.next;
  }

  public ListNode mergeTwoList2(ListNode l1, ListNode l2) {
    if (l1 == null) {
      return l2;
    } else if (l2 == null) {
      return l1;
    } else if (l1.val < l2.val) {
      l1.next = mergeTwoList2(l1.next, l2);
      return l1;
    } else {
      l2.next = mergeTwoList(l1, l2.next);
      return l2;
    }
  }

}
