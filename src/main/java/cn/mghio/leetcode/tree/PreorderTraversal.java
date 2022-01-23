package cn.mghio.leetcode.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Given the root of a binary tree, return the preorder traversal of its nodes' values.
 *
 * @author mghio
 * @since 2022-01-23
 */
public class PreorderTraversal {

  private final List<Integer> res = new ArrayList<>();

  /**
   * Given the root of a binary tree, return the preorder traversal of its nodes' values.
   *
   * @param root the root node
   * @return the preorder traversal of its nodes' values
   */
  public List<Integer> preorderTraversalSolution1(TreeNode root) {
    if (root == null) {
      return res;
    }

    res.add(root.val);
    preorderTraversalSolution1(root.left);
    preorderTraversalSolution1(root.right);
    return res;
  }

  /**
   * Given the root of a binary tree, return the preorder traversal of its nodes' values.
   *
   * @param root the root node
   * @return the preorder traversal of its nodes' values
   */
  public List<Integer> preorderTraversalSolution2(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    if (root == null) {
      return res;
    }

    Deque<TreeNode> stack = new LinkedList<>();
    TreeNode node = root;
    while (!stack.isEmpty() || node != null) {
      while (node != null) {
        res.add(node.val);
        stack.push(node);
        node = node.left;
      }
      node = stack.poll();
      assert node != null;
      node = node.right;
    }

    return res;
  }

}
