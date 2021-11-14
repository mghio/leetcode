package cn.mghio.leetcode.list;

/**
 * Given the head of a singly linked list, return the middle node of the linked list.
 *
 * If there are two middle nodes, return the second middle node.
 *
 * @author mghio
 * @since 2021-10-11
 */
public class MiddleNode {

  /**
   * Get the middle node.
   *
   * @param head the head node
   * @return the middle node
   */
  public SinglyNode middleNode(SinglyNode head) {
    SinglyNode slow = head, fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }

}
