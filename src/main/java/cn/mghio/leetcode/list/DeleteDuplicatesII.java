package cn.mghio.leetcode.list;

/**
 * Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving
 * only distinct numbers from the original list. Return the linked list sorted as well.
 *
 * @author mghio
 * @since 2022-01-23
 */
public class DeleteDuplicatesII {

  /**
   * Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving
   * only distinct numbers from the original list. Return the linked list sorted as well.
   *
   * @param head the head node
   * @return the linked list sorted as well
   */
  public ListNode deleteDuplicates(ListNode head) {
    if (head == null) {
      return null;
    }

    ListNode dummyNode = new ListNode(-1, head);
    ListNode curNode = dummyNode;
    while (curNode.next != null && curNode.next.next != null) {
      if (curNode.next.val == curNode.next.next.val) {
        int val = curNode.next.val;
        while (curNode.next != null && curNode.next.val == val) {
          curNode.next = curNode.next.next;
        }
      } else {
        curNode = curNode.next;
      }
    }

    return dummyNode.next;
  }

}
