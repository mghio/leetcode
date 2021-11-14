package cn.mghio.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given the root of a binary tree, return the bottom-up level order traversal of its nodes' values.
 * (i.e., from left to right, level by level from leaf to root).
 *
 * @author mghio
 * @since 2021-10-01
 */
public class BinaryTreeLevelOrderBottom {

  /**
   * the order-bottom travel of it's tree
   *
   * @param root the root node
   * @return the order-bottom travel nodes
   */
  public List<List<Integer>> levelOrderBottom(TreeNode root) {
    List<List<Integer>> values = new LinkedList<>();
    if (root == null) {
      return values;
    }

    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    while (!queue.isEmpty()) {
      List<Integer> levelValues = new ArrayList<>();
      for (int i = 0, size = queue.size(); i < size; i++) {
        TreeNode node = queue.poll();
        assert node != null;

        levelValues.add(node.val);
        if (node.left != null) {
          queue.add(node.left);
        }
        if (node.right != null) {
          queue.add(node.right);
        }
      }

      if (!levelValues.isEmpty()) {
        values.add(0, levelValues);
      }
    }

    return values;
  }

}
