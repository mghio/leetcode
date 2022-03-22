package cn.mghio.leetcode.list;

/**
 * Add Two Numbers.
 *
 * You are given two non-empty linked lists representing two non-negative integers. The digits are
 * stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and
 * return the sum as a linked list.
 *
 * @author mghio
 * @since 2022-03-20
 */
public class AddTwoNumbers {

  public static void main(String[] args) {
    ListNode node13 = new ListNode(3);
    ListNode node12 = new ListNode(4, node13);
    ListNode head1 = new ListNode(2, node12);

    ListNode node23 = new ListNode(4);
    ListNode node22 = new ListNode(6, node23);
    ListNode head2 = new ListNode(5, node22);

    AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
    addTwoNumbers.addTwoNumbers(head1, head2);
  }

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    if (l1 == null || l2 == null) {
      return l1 == null ? l2 : l1;
    }

    ListNode reverseL1 = reverse(l1);
    ListNode reverseL2 = reverse(l2);

    ListNode dummy = new ListNode(-1);
    ListNode p = dummy;
    int carry = 0;
    while (reverseL1 != null || reverseL2 != null) {
      int val;
      int curCarry = 0;
      if (reverseL1 != null && reverseL2 != null) {
        val = reverseL1.val + reverseL2.val;
        if (val >= 10) {
          curCarry = 1;
          val = val % 10;
        }
      } else if (reverseL1 != null) {
        val = reverseL1.val;
      } else {
        val = reverseL2.val;
      }

      if (carry != 0) {
        val++;
        if (val >= 10) {
          val = val % 10;
        }
      }
      carry = curCarry;
      p.next = new ListNode(val);
      p = p.next;

      if (reverseL1 != null) {
        reverseL1 = reverseL1.next;
      }

      if (reverseL2 != null) {
        reverseL2 = reverseL2.next;
      }
    }

    return dummy.next;
  }

  public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
    if (l1 == null || l2 == null) {
      return l1 == null ? l2 : l1;
    }

    ListNode head = null;
    ListNode p = null;
    int carry = 0;
    while (l1 != null || l2 != null) {
      int v1 = l1 != null ? l1.val : 0;
      int v2 = l2 != null ? l2.val : 0;
      int sum = v1 + v2 + carry;

      if (head == null) {
        head = new ListNode(sum % 10);
        p = head;
      } else {
        p.next = new ListNode(sum % 10);
        p = p.next;
      }

      carry = sum / 10;
      if (l1 != null) {
        l1 = l1.next;
      }
      if (l2 != null) {
        l2 = l2.next;
      }
    }

    if (carry > 0) {
      p.next = new ListNode(carry);
    }

    return head;
  }

  private ListNode reverse(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }

    ListNode last = reverse(head.next);
    head.next.next = head;
    head.next = null;
    return last;
  }

}
