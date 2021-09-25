package java.cn.mghio.leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Binary tree postorder traversal.
 *
 * Given the root of a binary tree, return the postorder traversal of its nodes' values.
 *
 * @author mghio
 * @since 2021-09-25
 */
public class BinaryTreePostOrderTraversal {

  /**
   * postorder traversal binary tree in recursion.
   *
   * @param root the root node
   * @return tree node values
   */
  public List<Integer> postOrderTraversalRecursion(TreeNode root) {
    if (root == null) {
      return new ArrayList<>();
    }

    List<Integer> values = postOrderTraversalRecursion(root.left);
    values.addAll(postOrderTraversalRecursion(root.right));
    values.add(root.val);

    return values;
  }

  /**
   * postorder traversal binary tree in iteration.
   *
   * @param root the root node
   * @return the tree values
   */
  public List<Integer> postOrderTraversalIteration(TreeNode root) {
    if (root == null) {
      return new ArrayList<>();
    }

    List<Integer> values = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    TreeNode pre = null;
    while (root != null || !stack.isEmpty()) {
      while (root != null) {
        stack.push(root);
        root = root.left;
      }
      root = stack.pop();
      if (root.right == null || root.right == pre) {
        values.add(root.val);
        pre = root;
        root = null;
      } else {
        stack.push(root);
        root = root.right;
      }
    }

    return values;
  }

}
