package cn.mghio.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, find its minimum depth.
 *
 * @author mghio
 * @since 2022-02-16
 */
public class MinDepth {

  /**
   * Given a binary tree, find its minimum depth.
   *
   * @param root the root node
   * @return the minimum depth
   */
  public int minDepthUseBFS(TreeNode root) {
    if (root == null) {
      return 0;
    }

    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    int depth = 1;

    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        TreeNode node = queue.poll();
        assert node != null;
        if (node.left == null && node.right == null) {
          return depth;
        }

        if (node.left != null) {
          queue.offer(node.left);
        }

        if (node.right != null) {
          queue.offer(node.right);
        }
      }
      depth++;
    }
    return depth;
  }

  /**
   * Given a binary tree, find its minimum depth.
   *
   * @param root the root node
   * @return the minimum depth
   */
  public int minDepthUseDFS(TreeNode root) {
    if (root == null) {
      return 0;
    }

    int depth = 1;
    if (root.left == null && root.right == null) {
      return depth;
    }

    int minDepth = Integer.MAX_VALUE;

    if (root.left != null) {
      minDepth = Math.min(minDepthUseDFS(root.left), minDepth);
    }

    if (root.right != null) {
      minDepth = Math.min(minDepthUseDFS(root.right), minDepth);
    }

    return minDepth + 1;
  }

}
