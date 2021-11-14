package cn.mghio.leetcode.list;

/**
 * Given the head of a linked list, return the node where the cycle begins. If there is no cycle,
 * return null.
 *
 * @author mghio
 * @since 2021-10-12
 */
public class DetectCycle {

  /**
   * Find the node where the cycle begin.
   *
   * @param head the head node
   * @return the node where the cycle begin
   */
  public SinglyNode detectCycle(SinglyNode head) {
    if (head == null) {
      return null;
    }

    SinglyNode fast = head, slow = head;
    while (fast != null) {
      slow = slow.next;
      if (fast.next != null) {
        fast = fast.next.next;
      } else {
        return null;
      }

      if (slow == fast) {
        slow = head;
        while (slow != fast) {
          slow = slow.next;
          fast = fast.next;
        }
        return slow;
      }
    }

    return null;
  }

}
