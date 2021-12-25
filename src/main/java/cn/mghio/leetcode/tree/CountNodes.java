package cn.mghio.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given the root of a complete binary tree, return the number of the nodes in the tree.
 *
 * @author mghio
 * @since 2021-12-25
 */
public class CountNodes {

  /**
   * Given the root of a complete binary tree, return the number of the nodes in the tree.
   *
   * @param root the root node
   * @return the number of the nodes in the tree
   */
  public int countNodesSolution1(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return countNodesSolution1(root.left) + countNodesSolution1(root.right) + 1;
  }

  /**
   * Given the root of a complete binary tree, return the number of the nodes in the tree.
   *
   * @param root the root node
   * @return the number of the nodes in the tree
   */
  public int countNodesSolution2(TreeNode root) {
    if (root == null) {
      return 0;
    }

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    int ans = 0;
    while (!queue.isEmpty()) {
      int size = queue.size();
      while (size > 0) {
        TreeNode currentNode = queue.poll();
        ans++;
        // always true
        assert currentNode != null;
        if (currentNode.left != null) {
          queue.offer(currentNode.left);
        }
        if (currentNode.right != null) {
          queue.offer(currentNode.right);
        }
        size--;
      }
    }
    return ans;
  }

}
