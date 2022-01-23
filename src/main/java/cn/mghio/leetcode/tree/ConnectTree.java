package cn.mghio.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * You are given a perfect binary tree where all leaves are on the same level, and every parent has
 * two children.
 *
 * @author mghio
 * @since 2021-12-25
 */
public class ConnectTree {

  /**
   * You are given a perfect binary tree where all leaves are on the same level, and every parent has
   * two children.
   *
   * @param root the root node
   * @return the connected tree node
   */
  public TreeNode connect(TreeNode root) {
    if (root == null) {
      return null;
    }

    connectTwoNode(root.left, root.right);
    return root;
  }

  /**
   * You are given a perfect binary tree where all leaves are on the same level, and every parent has
   * two children.
   *
   * @param root the root node
   * @return the connected tree node
   */
  public TreeNode connectSolution2(TreeNode root) {
    if (root == null) {
      return null;
    }

    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      int levelSize = queue.size();
      for (int i = 0; i < levelSize; i++) {
        TreeNode node = queue.poll();
        assert node != null;
        if (i < levelSize - 1) {
          node.next = queue.peek();
        }

        if (node.left != null) {
          queue.add(node.left);
        }
        if (node.right != null) {
          queue.add(node.right);
        }
      }
    }

    return root;
  }

  /**
   * You are given a perfect binary tree where all leaves are on the same level, and every parent has
   * two children.
   *
   * @param root the root node
   * @return the connected tree node
   */
  public TreeNode connectSolution3(TreeNode root) {
    if (root == null) {
      return null;
    }

    TreeNode leftMost = root;
    while (leftMost.left != null) {
      TreeNode head = leftMost;
      while (head != null) {
        head.left.next = head.right;
        if (head.next != null) {
          head.right.next = head.next.left;
        }
        head = head.next;
      }
      leftMost = leftMost.left;
    }

    return root;
  }

  private void connectTwoNode(TreeNode node1, TreeNode node2) {
    if (node1 == null || node2 == null) {
      return;
    }

    connectTwoNode(node1.left, node1.right);
    connectTwoNode(node2.left, node2.right);
    connectTwoNode(node1.right, node2.left);
  }

}
