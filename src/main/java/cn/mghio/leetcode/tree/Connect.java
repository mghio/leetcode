package cn.mghio.leetcode.tree;

/**
 * You are given a perfect binary tree where all leaves are on the same level, and every parent has
 * two children. The binary tree has the following definition:
 *
 * @author mghio
 * @since 2022-03-09
 */
public class Connect {

  public Node connect(Node root) {
    if (root == null || root.left == null) {
      return root;
    }

    connectTwoNodes(root.left, root.right);
    return root;
  }

  private void connectTwoNodes(Node node1, Node node2) {
    if (node1 == null || node2 == null) {
      return;
    }

    node1.next = node2;
    connectTwoNodes(node1.left, node1.right);
    connectTwoNodes(node2.left, node2.right);
    connectTwoNodes(node1.right, node2.left);
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
