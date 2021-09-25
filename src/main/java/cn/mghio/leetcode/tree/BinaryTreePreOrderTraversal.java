package java.cn.mghio.leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Binary tree preorder traversal.
 *
 * Given the root of a binary tree, return the preorder traversal of its nodes' values.
 *
 * @author mghio
 * @since 2021-09-25
 */
public class BinaryTreePreOrderTraversal {

  /**
   * preorder traversal binary tree in recursion.
   *
   * @param root the root node
   * @return tree node values
   */
  public List<Integer> preOrderTraversalRecursion(TreeNode root) {
    if (root == null) {
      return new ArrayList<>();
    }

    List<Integer> values = new ArrayList<>();
    values.add(root.val);
    values.addAll(preOrderTraversalRecursion(root.left));
    values.addAll(preOrderTraversalRecursion(root.right));

    return values;
  }

  /**
   * preorder traversal binary tree in iteration.
   *
   * @param root the root node
   * @return tree node values
   */
  public List<Integer> preOrderTraversalIteration(TreeNode root) {
    if (root == null) {
      return new ArrayList<>();
    }

    List<Integer> values = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);
    while (!stack.isEmpty()) {
      TreeNode node = stack.pop();
      values.add(node.val);
      if (node.right != null) {
        stack.push(node.right);
      }
      if (node.left != null) {
        stack.push(node.left);
      }
    }
    return values;
  }

}
