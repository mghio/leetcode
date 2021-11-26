package cn.mghio.leetcode.list;

/**
 * Given the head of a singly linked list, return true if it is a palindrome.
 *
 * @author mghio
 * @since 2021-11-24
 */
public class IsPalindrome {

  private ListNode left;

  /**
   * Return true if it is a palindrome.
   *
   * @param head the head node
   * @return true if it is a palindrome, else false
   */
  public boolean isPalindromeSolution1(ListNode head) {
    left = head;
    return traverse(head);
  }

  /**
   * Return true if it is a palindrome.
   *
   * @param head the head node
   * @return true if it is a palindrome, else false
   */
  public boolean isPalindromeSolution2(ListNode head) {
    if (head == null) {
      return true;
    }

    ListNode left = head;
    ListNode slow = findToReverseHeadNode(head);
    ListNode right = reverse(slow);

    while (right != null) {
      if (left.val != right.val) {
        return false;
      }
      left = left.next;
      right = right.next;
    }

    return true;
  }

  private ListNode reverse(ListNode head) {
    ListNode pre = null;
    ListNode cur = head;
    while (cur != null) {
      ListNode next = cur.next;
      cur.next = pre;
      pre = cur;
      cur = next;
    }
    return pre;
  }

  private boolean traverse(ListNode right) {
    if (right == null) {
      return true;
    }
    boolean ans = traverse(right.next);
    ans = ans && (right.val == left.val);
    left = left.next;
    return ans;
  }

  private ListNode findToReverseHeadNode(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    if (fast != null) {
      slow = slow.next;
    }
    return slow;
  }

  public static void main(String[] args) {
    ListNode node = new ListNode(1, new ListNode(2));
    IsPalindrome palindrome = new IsPalindrome();
    boolean ans = palindrome.isPalindromeSolution2(node);
    System.out.println(ans);
  }

}
