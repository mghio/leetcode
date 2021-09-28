package java.cn.mghio.leetcode.tree;

/**
 * Given a binary tree, Populate each next pointer to point to its next right node. If there is no
 * next right node, the next pointer should be set to NULL. Initially, all next pointers are set to
 * NULL.
 *
 * @author mghio
 * @since 2021-09-28
 */
public class BinaryTreeConnect {

  /**
   * connect given a binary tree.
   *
   * @param root the root node
   * @return the connected binary tree node
   */
  public Node connect(Node root) {
    if (root == null) {
      return null;
    }

    Node cur = root;
    while (cur != null) {
      Node dummy = new Node(0);
      Node pre = dummy;
      // travel current level
      while (cur != null) {
        if (cur.left != null) {
          pre.next = cur.left;
          pre = pre.next;
        }
        if (cur.right != null) {
          pre.next = cur.right;
          pre = pre.next;
        }
        cur = cur.next;
      }
      cur = dummy.next;
    }

    return root;
  }

}
