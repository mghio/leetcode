package cn.mghio.leetcode.list;

/**
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 *
 * @author mghio
 * @since 2022-03-08
 */
public class ListHasCycle {

  public boolean hasCycle(ListNode head) {
    if (head == null) {
      return false;
    }

    ListNode slow = head;
    ListNode fast = head;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        return true;
      }
    }
    return false;
  }

}
