package java.cn.mghio.leetcode.list;

/**
 * Given the head of a singly linked list, sort the list using insertion sort, and return the sorted
 * list's head.
 *
 * @author mghio
 * @since 2021-10-19
 */
public class InsertionSortList {

  /**
   * Sort the list using insertion sort, and return the sorted list's head.
   *
   * @param head the head node
   * @return the sorted singly-linked list
   */
  public SinglyNode insertionSortList(SinglyNode head) {
    if (head == null) {
      return null;
    }

    SinglyNode dummyHead = new SinglyNode(-1, head);
    SinglyNode lastSorted = head, curr = head.next;
    while (curr != null) {
      if (lastSorted.val <= curr.val) {
        lastSorted = lastSorted.next;
      } else {
        // find pre from the head node
        SinglyNode pre = dummyHead;
        while (pre.next.val <= curr.val) {
          pre = pre.next;
        }
        // insert
        lastSorted.next = curr.next;
        curr.next = pre.next;
        pre.next = curr;
      }
      curr = lastSorted.next;
    }

    return dummyHead.next;
  }

}
