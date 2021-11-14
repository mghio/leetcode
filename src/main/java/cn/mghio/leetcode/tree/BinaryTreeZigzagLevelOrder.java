package cn.mghio.leetcode.tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given the root of a binary tree, return the zigzag level order traversal of its nodes' values.
 * (i.e., from left to right, then right to left for the next level and alternate between).
 *
 * @author mghio
 * @since 2021-10-01
 */
public class BinaryTreeZigzagLevelOrder {

  /**
   * Given a binary tree, then return the zigzag level order.
   *
   * @param root the root node
   * @return the zigzag level order
   */
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> values = new LinkedList<>();
    if (root == null) {
      return values;
    }

    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    boolean isLeftOrder = true;
    while (!queue.isEmpty()) {
      Deque<Integer> levelValues = new LinkedList<>();
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        TreeNode node = queue.poll();
        assert node != null;

        if (isLeftOrder) {
          levelValues.offerLast(node.val);
        } else {
          levelValues.offerFirst(node.val);
        }

        if (node.left != null) {
          queue.offer(node.left);
        }
        if (node.right != null) {
          queue.offer(node.right);
        }
      }

      isLeftOrder = !isLeftOrder;
      values.add(new LinkedList<>(levelValues));
    }

    return values;
  }

}
