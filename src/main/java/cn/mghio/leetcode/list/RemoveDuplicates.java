package cn.mghio.leetcode.list;

/**
 * Given the head of a sorted linked list, delete all duplicates such that each element appears only
 * once. Return the linked list sorted as well.
 *
 * @author mghio
 * @since 2021-12-09
 */
public class RemoveDuplicates {

  /**
   * Given the head of a sorted linked list, delete all duplicates such that each element appears
   * only once.
   *
   * @param head the head node
   * @return the linked list sorted as well
   */
  public ListNode removeDuplicates(ListNode head) {
    if (head == null) {
      return null;
    }

    ListNode slow = head, fast = head;
    while (fast != null) {
      if (slow.val != fast.val) {
        slow = slow.next;
        slow.val = fast.val;
      }
      fast = fast.next;
    }

    slow.next = null;
    return head;
  }

  /**
   * Given the head of a sorted linked list, delete all duplicates such that each element appears
   * only once.
   *
   * @param head the head node
   * @return the linked list sorted as well
   */
  public ListNode removeDuplicatesSolution2(ListNode head) {
    if (head == null) {
      return null;
    }

    ListNode cur = head;
    while (cur.next != null) {
      if (cur.val == cur.next.val) {
        cur.next = cur.next.next;
      } else {
        cur = cur.next;
      }
    }

    return head;
  }

}
