package cn.mghio.leetcode.bst;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Implement a function to check if a binary tree is a binary search tree.
 *
 * @author mghio
 * @since 2022-01-26
 */
public class IsValidBST {

  /**
   * Implement a function to check if a binary tree is a binary search tree.
   *
   * @param root the root node
   * @return return true if a binary tree is a binary search tree, else false
   */
  public boolean isValidBST(TreeNode root) {
    return isValidBST(root, null, null);
  }

  /**
   * Implement a function to check if a binary tree is a binary search tree.
   *
   * @param root the root node
   * @return return true if a binary tree is a binary search tree, else false
   */
  public boolean isValidBSTSolution2(TreeNode root) {
    Deque<TreeNode> stack = new LinkedList<>();
    int inorder = Integer.MIN_VALUE;

    while (!stack.isEmpty() || root != null) {
      while (root != null) {
        stack.push(root);
        root = root.left;
      }

      root = stack.pop();
      if (root.val <= inorder) {
        return false;
      }
      inorder = root.val;
      root = root.right;
    }
    return true;
  }

  /**
   * min.val < root.val < max.val
   */
  private boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
    if (root == null) {
      return true;
    }

    if (min != null && root.val <= min.val) {
      return false;
    }

    if (max != null && root.val >= max.val) {
      return false;
    }

    return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
  }

}
