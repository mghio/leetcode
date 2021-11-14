package cn.mghio.leetcode.list;

/**
 * Determine whether the linked list contains a cycle.
 *
 * @author mghio
 * @since 2021-10-12
 */
public class HasCycle {

  /**
   * Determine whether the linked list contains a cycle.
   *
   * @param head the head node
   * @return true has cycled, else false
   */
  public boolean hasCycle(SinglyNode head) {
    if (head == null) {
      return false;
    }

    SinglyNode fast = head, slow = head;
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
