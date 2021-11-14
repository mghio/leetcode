package cn.mghio.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given the root of a binary tree, imagine yourself standing on the right side of it, return the
 * values of the nodes you can see ordered from top to bottom.
 *
 * @author mghio
 * @since 2021-09-30
 */
public class BinaryTreeRightSideView {

  /**
   * Given the root of a binary tree, fetch right side view.
   *
   * @param root the root node
   * @return the right side view
   */
  public List<Integer> rightSideView(TreeNode root) {
    if (root == null) {
      return new ArrayList<>();
    }

    List<Integer> values = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        TreeNode node = queue.poll();

        assert node != null;
        if (i == size - 1) {
          values.add(node.val);
        }
        if (node.left != null) {
          queue.add(node.left);
        }
        if (node.right != null) {
          queue.add(node.right);
        }
      }
    }

    return values;
  }

}
