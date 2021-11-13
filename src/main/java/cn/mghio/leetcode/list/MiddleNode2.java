package java.cn.mghio.leetcode.list;

/**
 * @author mghio
 * @since 2021-11-13
 */
public class MiddleNode2 {

  public ListNode middleNode(ListNode head) {
    if (head == null) {
      return null;
    }

    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    return slow;
  }

}
