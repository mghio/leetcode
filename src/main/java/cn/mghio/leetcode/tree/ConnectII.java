package cn.mghio.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Populate each next pointer to point to its next right node. If there is no next right node, the
 * next pointer should be set to NULL.
 *
 * Initially, all next pointers are set to NULL.
 *
 * @author mghio
 * @since 2022-03-09
 */
public class ConnectII {

  public Node connect(Node root) {
    if (root == null) {
      return null;
    }

    Queue<Node> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      Node last = null;
      for (int i = 0; i < size; i++) {
        Node node = queue.poll();
        assert node != null;

        if (node.left != null) {
          queue.offer(node.left);
        }

        if (node.right != null) {
          queue.offer(node.right);
        }

        if (i != 0) {
          last.next = node;
        }
        last = node;
      }
    }

    return root;
  }

  static class Node {

    int val;
    Node left;
    Node right;
    Node next;

    public Node() {
    }

    public Node(int val) {
      this.val = val;
    }

    public Node(int val, Node left, Node right, Node next) {
      this.val = val;
      this.left = left;
      this.right = right;
      this.next = next;
    }
  }

}
