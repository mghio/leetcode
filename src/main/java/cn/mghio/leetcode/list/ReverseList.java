package java.cn.mghio.leetcode.list;

/**
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 *
 * @author mghio
 * @since 2021-10-14
 */
public class ReverseList {

  /**
   * Reverse singly-linked list
   *
   * @param head the head node
   * @return the reversed singly-linked list
   */
  public SinglyNode reverseListRecursion(SinglyNode head) {
    if (head == null || head.next == null) {
      return head;
    }

    SinglyNode last = reverseListRecursion(head.next);
    head.next.next = head;
    head.next = null;
    return last;
  }

  /**
   * Reverse singly-linked list
   *
   * @param head the head node
   * @return the reversed singly-linked list
   */
  public SinglyNode reverseListIteration(SinglyNode head) {
    SinglyNode pre = null;
    SinglyNode cur = head;
    while (cur != null) {
      SinglyNode next = cur.next;
      cur.next = pre;
      pre = cur;
      cur = next;
    }
    return pre;
  }

}
