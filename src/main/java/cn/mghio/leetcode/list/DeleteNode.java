package cn.mghio.leetcode.list;

/**
 * Delete Node in a Linked List.
 *
 * @author mghio
 * @since 2022-03-29
 */
public class DeleteNode {

  public void deleteNode(ListNode node) {
    node.val = node.next.val;
    node.next = node.next.next;
  }

}
