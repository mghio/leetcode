package cn.mghio.leetcode.list;

import java.util.HashSet;
import java.util.Set;

/**
 * @author mghio
 * @since 2021-11-12
 */
public class DetectCycle2 {

  /**
   * Detect single list cycle.
   *
   * @param head the head node
   * @return return not null if detect cycle, else return null
   */
  public ListNode detectCycleSolution1(ListNode head) {
    if (head == null || head.next == null) {
      return null;
    }

    ListNode pos = head;
    Set<ListNode> visited = new HashSet<>();
    while (pos != null) {
      if (visited.contains(pos)) {
        return pos;
      } else {
        visited.add(pos);
      }
      pos = pos.next;
    }

    return null;
  }

  /**
   * Detect single list cycle.
   *
   * @param head the head node
   * @return return not null if detect cycle, else return null
   */
  public ListNode detectCycleSolution2(ListNode head) {
    if (head == null || head.next == null) {
      return null;
    }

    ListNode slow = head;
    ListNode fast = head;
    while (fast != null) {
      slow = slow.next;
      if (fast.next != null) {
        fast = fast.next.next;
      } else {
        return null;
      }

      if (fast == slow) {
        ListNode ptr = head;
        while (ptr != slow) {
          ptr = ptr.next;
          slow = slow.next;
        }
        return ptr;
      }
    }
    return null;
  }

}
