package cn.mghio.leetcode.doublepoint;

/**
 * Given the head of a sorted linked list, delete all duplicates such that each element appears only
 * once. Return the linked list sorted as well.
 *
 * @author mghio
 * @since 2022-02-27
 */
public class DeleteDuplicates {

  public ListNode deleteDuplicates(ListNode head) {
    if (head == null) {
      return null;
    }

    ListNode fast = head;
    ListNode slow = head;
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


  public ListNode deleteDuplicatesSolution2(ListNode head) {
    if (head == null) {
      return null;
    }

    ListNode curr = head;
    while (curr.next != null) {
      if (curr.val == curr.next.val) {
        curr.next = curr.next.next;
      } else {
        curr = curr.next;
      }
    }

    return head;
  }

}
