package cn.mghio.leetcode.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Given the root of a binary tree, flatten the tree into a "linked list".
 *
 * @author mghio
 * @since 2021-12-25
 */
public class Flatten {

  /**
   * Given the root of a binary tree, flatten the tree into a "linked list".
   *
   * @param root the root node
   */
  public void flattenSolution1(TreeNode root) {
    if (root == null) {
      return;
    }

    flattenSolution1(root.left);
    flattenSolution1(root.right);

    TreeNode left = root.left;
    TreeNode right = root.right;

    root.left = null;
    root.right = left;

    TreeNode p = root;
    while (p.right != null) {
      p = p.right;
    }
    p.right = right;
  }

  private final List<TreeNode> preOrderNodes = new ArrayList<>();

  /**
   * Given the root of a binary tree, flatten the tree into a "linked list".
   *
   * @param root the root node
   */
  public void flattenSolution2(TreeNode root) {
    if (root == null) {
      return;
    }

    preOrderTraversal(root, preOrderNodes);

    for (int i = 1, len = preOrderNodes.size(); i < len; i++) {
      TreeNode pre = preOrderNodes.get(i - 1);
      TreeNode cur = preOrderNodes.get(i);
      pre.left = null;
      pre.right = cur;
    }
  }

  /**
   * Given the root of a binary tree, flatten the tree into a "linked list".
   *
   * @param root the root node
   */
  public void flattenSolution3(TreeNode root) {
    if (root == null) {
      return;
    }

    List<TreeNode> preOrderNodes = new ArrayList<>();
    Deque<TreeNode> stack = new LinkedList<>();
    TreeNode node = root;
    while (!stack.isEmpty() || node != null) {
      while (node != null) {
        preOrderNodes.add(node);
        stack.push(node);
        node = node.left;
      }
      node = stack.poll();
      assert node != null;
      node = node.right;
    }

    int size = preOrderNodes.size();
    for (int i = 1; i < size; i++) {
      TreeNode pre = preOrderNodes.get(i - 1);
      TreeNode cur = preOrderNodes.get(i);
      pre.left = null;
      pre.right = cur;
    }
  }

  /**
   * Given the root of a binary tree, flatten the tree into a "linked list".
   *
   * @param root the root node
   */
  public void flattenSolution4(TreeNode root) {
    if (root == null) {
      return;
    }

    Deque<TreeNode> stack = new LinkedList<>();
    stack.push(root);
    TreeNode prev = null;

    while (!stack.isEmpty()) {
      TreeNode cur = stack.poll();
      if (prev != null) {
        prev.left = null;
        prev.right = cur;
      }

      TreeNode right = cur.right;
      if (right != null) {
        stack.push(right);
      }
      TreeNode left = cur.left;
      if (left != null) {
        stack.push(left);
      }
      prev = cur;
    }
  }

  private void preOrderTraversal(TreeNode node, List<TreeNode> preOrderNodes) {
    if (node != null) {
      preOrderNodes.add(node);
      preOrderTraversal(node.left, preOrderNodes);
      preOrderTraversal(node.right, preOrderNodes);
    }
  }

}
