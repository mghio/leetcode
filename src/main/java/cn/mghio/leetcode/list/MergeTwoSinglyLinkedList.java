package java.cn.mghio.leetcode.list;

/**
 * Merge two sorted linked lists and return it as a sorted list. The list should be made by splicing
 * together the nodes of the first two lists.
 *
 * @author mghio
 * @since 2021-10-04
 */
public class MergeTwoSinglyLinkedList {

  /**
   * Merge two singly-linked list.
   *
   * @param l1 the singly-linked list
   * @param l2 the other singly-linked list
   * @return the merged singly-linked list
   */
  public SinglyNode mergeTwoLists(SinglyNode l1, SinglyNode l2) {
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
