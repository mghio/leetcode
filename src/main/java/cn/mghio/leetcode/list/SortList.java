package java.cn.mghio.leetcode.list;

/**
 * Given the head of a singly-linked list, return the list after sorting it in ascending order.
 *
 * @author mghio
 * @since 2021-10-20
 */
public class SortList {

  /**
   * Given the head of a singly-linked list, return the list after sorting it in ascending order.
   *
   * @param head the head node
   * @return the sorted singly-linked list.
   */
  public SinglyNode sortList(SinglyNode head) {
    if (head == null) {
      return null;
    }

    return sortList(head, null);
  }

  private SinglyNode sortList(SinglyNode head, SinglyNode tail) {
    if (head == null) {
      return null;
    }

    if (head.next == tail) {
      head.next = null;
      return head;
    }

    // find the middle node
    SinglyNode slow = head, fast = head;
    while (fast != tail) {
      slow = slow.next;
      fast = fast.next;
      if (fast != tail) {
        fast = fast.next;
      }
    }

    SinglyNode middle = slow;
    SinglyNode list1 = sortList(head, middle);
    SinglyNode list2 = sortList(middle, tail);
    return merge(list1, list2);
  }

  private SinglyNode merge(SinglyNode head1, SinglyNode head2) {
    SinglyNode dummyHead = new SinglyNode(-1);
    SinglyNode tmp = dummyHead, tmp1 = head1, tmp2 = head2;
    while (tmp1 != null && tmp2 != null) {
      if (tmp1.val <= tmp2.val) {
        tmp.next = tmp1;
        tmp1 = tmp1.next;
      } else {
        tmp.next = tmp2;
        tmp2 = tmp2.next;
      }
      tmp = tmp.next;
    }

    if (tmp1 != null) {
      tmp.next = tmp1;
    } else if (tmp2 != null) {
      tmp.next = tmp2;
    }

    return dummyHead.next;
  }

}
