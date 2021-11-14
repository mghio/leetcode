package cn.mghio.leetcode.list;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 * Merge all the linked-lists into one sorted linked-list and return it.
 *
 * @author mghio
 * @since 2021-10-04
 */
public class MergeKLists {

  /**
   * Merge the K sorted singly-linked lists.
   *
   * @param lists the lists
   * @return the merged list
   */
  public SinglyNode mergeKListsV1(SinglyNode[] lists) {
    SinglyNode ret = null;
    for (SinglyNode list : lists) {
      ret = mergeTwoLists(ret, list);
    }
    return ret;
  }

  /**
   * Merge the K sorted singly-linked lists.
   *
   * @param lists the lists
   * @return the merged list
   */
  public SinglyNode mergeKListsV2(SinglyNode[] lists) {
    if (lists == null || lists.length == 0) {
      return null;
    }

    SinglyNode dummy = new SinglyNode(-1);
    SinglyNode p = dummy;
    // min heap, default is min heap
    PriorityQueue<SinglyNode> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
    for (SinglyNode node : lists) {
      if (node != null) {
        minHeap.add(node);
      }
    }

    while (!minHeap.isEmpty()) {
      SinglyNode singlyNode = minHeap.poll();
      p.next = singlyNode;
      if (singlyNode.next != null) {
        minHeap.add(singlyNode.next);
      }
      p = p.next;
    }

    return dummy.next;
  }

  private SinglyNode mergeTwoLists(SinglyNode l1, SinglyNode l2) {
    if (l1 == null || l2 == null) {
      return l1 == null ? l2 : l1;
    }

    SinglyNode head = new SinglyNode(0);
    SinglyNode tail = head;
    SinglyNode aPtr = l1;
    SinglyNode bPtr = l2;

    while (aPtr != null && bPtr != null) {
      if (aPtr.val < bPtr.val) {
        tail.next = aPtr;
        aPtr = aPtr.next;
      } else {
        tail.next = bPtr;
        bPtr = bPtr.next;
      }
      tail = tail.next;
    }

    tail.next = aPtr == null ? bPtr : aPtr;
    return head.next;
  }

}
