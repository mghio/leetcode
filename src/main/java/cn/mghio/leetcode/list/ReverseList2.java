package java.cn.mghio.leetcode.list;

/**
 * @author mghio
 * @since 2021-11-12
 */
public class ReverseList2 {

  /**
   * given head of single list, reverse single list.
   *
   * @param head the head node
   * @return the reversed list node
   */
  public ListNode reverseList(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }

    ListNode newNode = reverseList(head.next);
    head.next.next = head;
    head.next = null;
    return newNode;
  }

}
