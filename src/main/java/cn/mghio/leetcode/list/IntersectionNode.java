package java.cn.mghio.leetcode.list;

import java.util.ArrayList;
import java.util.List;

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
  public SinglyNode getIntersectionNodeV1(SinglyNode headA, SinglyNode headB) {
    if (headA == null || headB == null) {
      return null;
    }

    List<SinglyNode> headANodes = new ArrayList<>();
    SinglyNode nodeA = headA;
    headANodes.add(headA);
    while (nodeA.next != null) {
      nodeA = nodeA.next;
      headANodes.add(nodeA);
    }

    SinglyNode nodeB = headB;
    if (headANodes.contains(nodeB)) {
      return nodeB;
    }
    while (nodeB.next != null) {
      nodeB = nodeB.next;
      if (headANodes.contains(nodeB)) {
        return nodeB;
      }
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
  public SinglyNode getIntersectionNodeV2(SinglyNode headA, SinglyNode headB) {
    if (headA == null || headB == null) {
      return null;
    }

    SinglyNode p1 = headA, p2 = headB;
    while (p1 != p2) {
      if (p1 == null) {
        p1 = headB;
      } else {
        p1 = p1.next;
      }

      if (p2 == null) {
        p2 = headA;
      } else {
        p2 = p2.next;
      }
    }

    return p2;
  }

}
