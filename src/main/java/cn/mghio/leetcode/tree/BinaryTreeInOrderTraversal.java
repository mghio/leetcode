package java.cn.mghio.leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Binary tree inorder traversal.
 *
 * Given the root of a binary tree, return the inorder traversal of its nodes' values.
 *
 * @author mghio
 * @since 2021-09-25
 */
public class BinaryTreeInOrderTraversal {

  /**
   * inorder traversal binary tree in recursion.
   *
   * @param root the root node
   * @return tree node values
   */
  public List<Integer> inOrderTraversalRecursion(TreeNode root) {
    if (root == null) {
      return new ArrayList<>();
    }

    List<Integer> values = new ArrayList<>(inOrderTraversalRecursion(root.left));
    values.add(root.val);
    values.addAll(inOrderTraversalRecursion(root.right));

    return values;
  }

  /**
   * inorder traversal binary tree in iteration.
   *
   * @param root the root node
   * @return tree node values
   */
  public List<Integer> inOrderTraversalIteration(TreeNode root) {
    if (root == null) {
      return new ArrayList<>();
    }

    TreeNode curNode = root;
    List<Integer> values = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    while (curNode != null || !stack.isEmpty()) {
      while (curNode != null) {
        stack.push(curNode);
        curNode = curNode.left;
      }
      curNode = stack.pop();
      values.add(curNode.val);
      curNode = curNode.right;
    }

    return values;
  }

}
