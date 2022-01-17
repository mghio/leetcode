package cn.mghio.leetcode.list;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 *
 * Merge all the linked-lists into one sorted linked-list and return it.
 *
 * @author mghio
 * @since 2022-01-17
 */
public class MergeKList {

  /**
   * Merge all the linked-lists into one sorted linked-list and return it.
   *
   * @param lists the list node array
   * @return the result
   */
  public ListNode mergeKList(ListNode[] lists) {
    if (lists == null || lists.length == 0) {
      return null;
    }

    ListNode dummy = new ListNode(-1);
    ListNode p = dummy;
    // min heap
    PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
      @Override
      public int compare(ListNode l1, ListNode l2) {
        return l1.val - l2.val;
      }
    });

    for (ListNode head : lists) {
      if (head != null) {
        queue.add(head);
      }
    }

    while (!queue.isEmpty()) {
      ListNode node = queue.poll();
      p.next = node;
      if (node.next != null) {
        queue.add(node.next);
      }
      p = p.next;
    }

    return dummy.next;
  }

}
