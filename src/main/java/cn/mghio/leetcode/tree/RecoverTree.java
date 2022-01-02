package cn.mghio.leetcode.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * You are given the root of a binary search tree (BST), where the values of exactly two nodes of
 * the tree were swapped by mistake. Recover the tree without changing its structure.
 *
 * @author mghio
 * @since 2021-12-30
 */
public class RecoverTree {

  /**
   * recover the tree without changing its structure.
   *
   * @param root the root node
   */
  public void recoverTree(TreeNode root) {
    if (root == null) {
      return;
    }

    List<TreeNode> nodes = new LinkedList<>();
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    while (!queue.isEmpty()) {
      TreeNode node = queue.poll();
      assert node != null;

      if (!nodes.isEmpty()) {
        TreeNode maxNode = nodes.get(nodes.size() - 1);
        if (maxNode != null && maxNode.val > node.val) {
          int tmp = node.val;
          node.val = maxNode.val;
          maxNode.val = tmp;
        }
      }
      nodes.add(node);

      if (node.left != null) {
        queue.offer(node.left);
      }

      if (node.right != null) {
        queue.offer(node.right);
      }
    }
  }

}
