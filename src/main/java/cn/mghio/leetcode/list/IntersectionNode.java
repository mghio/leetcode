package cn.mghio.leetcode.list;

import java.util.HashSet;
import java.util.Set;

/**
 * Given the heads of two singly linked-lists headA and headB, return the node at which the two
 * lists intersect. If the two linked lists have no intersection at all, return null.
 *
 * @author mghio
 * @since 2021-10-12
 */
public class IntersectionNode {

  /**
   * Get intersection node.
   *
   * @param headA the head node
   * @param headB the other head node
   * @return the intersection node
   */
  public SinglyNode getIntersectionNodeSolution1(SinglyNode headA, SinglyNode headB) {
    if (headA == null || headB == null) {
      return null;
    }

    for (SinglyNode curNodeA = headA; curNodeA != null; ) {
      for (SinglyNode curNodeB = headB; curNodeB != null; ) {
        if (curNodeA == curNodeB) {
          return curNodeA;
        }
        curNodeB = curNodeB.next;
      }
      curNodeA = headA.next;
    }

    return null;
  }

  /**
   * Get intersection node.
   *
   * @param headA the head node
   * @param headB the other head node
   * @return the intersection node
   */
  public SinglyNode getIntersectionNodeSolution2(SinglyNode headA, SinglyNode headB) {
    if (headA == null || headB == null) {
      return null;
    }

    Set<SinglyNode> visited = new HashSet<>();
    SinglyNode tmp = headA;
    while (tmp != null) {
      visited.add(tmp);
      tmp = tmp.next;
    }

    tmp = headB;
    while (tmp != null) {
      if (visited.contains(tmp)) {
        return tmp;
      }
      tmp = tmp.next;
    }

    return null;
  }

  /**
   * Get intersection node.
   *
   * @param headA the head node
   * @param headB the other head node
   * @return the intersection node
   */
  public SinglyNode getIntersectionNodeSolution3(SinglyNode headA, SinglyNode headB) {
    if (headA == null || headB == null) {
      return null;
    }

    SinglyNode pA = headA;
    SinglyNode pB = headB;
    while (pA != pB) {
      pA = pA == null ? headB : pA.next;
      pB = pB == null ? headA : pB.next;
    }

    return pA;
  }

}
