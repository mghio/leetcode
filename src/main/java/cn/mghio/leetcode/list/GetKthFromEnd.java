package java.cn.mghio.leetcode.list;

/**
 * Input a linked list, and output the kth node from the bottom of the linked list. In order to
 * conform to the habits of most people, this question starts counting from 1, that is, the end node
 * of the linked list is the first node from the bottom.
 *
 * @author mghio
 * @since 2021-10-11
 */
public class GetKthFromEnd {

  /**
   * Input a linked list, and output the kth node from the bottom of the linked list.
   *
   * @param node the first node of linked list
   * @param k the k end
   * @return the kth node
   */
  public SinglyNode getKthFromEnd(SinglyNode node, int k) {
    if (node == null) {
      return null;
    }

    SinglyNode p1 = node;
    for (int i = 0; i < k; i++) {
      p1 = p1.next;
    }

    SinglyNode p2 = node;
    while (p1 != null) {
      p2 = p2.next;
      p1 = p1.next;
    }

    return p2;
  }

}
