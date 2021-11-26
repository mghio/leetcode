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

  private boolean traverse(ListNode right) {
    if (right == null) {
      return true;
    }
    boolean ans = traverse(right.next);
    ans = ans && (right.val == left.val);
    left = left.next;
    return ans;
  }

}
