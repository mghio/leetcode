package cn.mghio.leetcode.list;

/**
 * Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving
 * only distinct numbers from the original list. Return the linked list sorted as well.
 *
 * @author mghio
 * @since 2022-01-22
 */
public class DeleteDuplicates {

  /**
   * Return the linked list sorted as well.
   *
   * @param head the head node
   * @return the linked list sorted as well
   */
  public ListNode deleteDuplicatesSolution1(ListNode head) {
    if (head == null) {
      return null;
    }

    ListNode slow = head;
    ListNode fast = head.next;
    while (fast != null) {
      if (fast.val != slow.val) {
        slow.next = fast;
        slow = slow.next;
      }
      fast = fast.next;
    }
    slow.next = null;

    return head;
  }

}
