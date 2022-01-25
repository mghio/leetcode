package cn.mghio.leetcode.bst;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given the root of a binary search tree, and an integer k, return the kth smallest value
 * (1-indexed) of all the values of the nodes in the tree.
 *
 * @author mghio
 * @since 2022-01-25
 */
public class KthSmallest {

  private int res = 0;

  private int rank = 0;

  /**
   * Given the root of a binary search tree, and an integer k, return the kth smallest value
   * (1-indexed) of all the values of the nodes in the tree.
   *
   * @param root the root node
   * @param k the kth smallest
   * @return the kth smallest value (1-indexed) of all the values of the nodes in the tree
   */
  public int kthSmallest(TreeNode root, int k) {
    traverse(root, k);
    return res;
  }

  /**
   * Given the root of a binary search tree, and an integer k, return the kth smallest value
   * (1-indexed) of all the values of the nodes in the tree.
   *
   * @param root the root node
   * @param k the kth smallest
   * @return the kth smallest value (1-indexed) of all the values of the nodes in the tree
   */
  public int kthSmallestSolution2(TreeNode root, int k) {
    Deque<TreeNode> stack = new ArrayDeque<>();
    while (root != null || !stack.isEmpty()) {
      while (root != null) {
        stack.push(root);
        root = root.left;
      }
      root = stack.poll();
      --k;
      if (k == 0) {
        break;
      }
      root = root.right;
    }
    return root.val;
  }

  private void traverse(TreeNode root, int k) {
    if (root == null) {
      return;
    }

    traverse(root.left, k);

    rank++;
    if (rank == k) {
      res = root.val;
      return;
    }

    traverse(root.right, k);
  }

}
