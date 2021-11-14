package cn.mghio.leetcode.tree;

/**
 * @author mghio
 * @since 2021-09-28
 */
public class Node {

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
