package cn.mghio.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Please implement a function to print the binary tree in zigzag order, that is, the first line is
 * printed from left to right, the second layer is printed from right to left, and the third line is
 * printed from left to right. Others And so on.
 *
 * @author mghio
 * @since 2021-12-06
 */
public class LevelOrder {

  /**
   * print the binary tree in zigzag order, this first line is printed from left to right,
   * the second layer is printed from right to left.
   *
   * @param root the root node
   * @return the result
   */
  public List<List<Integer>> levelOrder(TreeNode root) {
    if (root == null) {
      return new ArrayList<>();
    }

    List<List<Integer>> ans = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      LinkedList<Integer> tmp = new LinkedList<>();
      int levelSize = queue.size();
      for (int i = 0; i < levelSize; i++) {
        TreeNode node = queue.poll();
        assert node != null;

        if (ans.size() % 2 == 0) {
          tmp.addLast(node.val);
        } else {
          tmp.addFirst(node.val);
        }
        if (node.left != null) {
          queue.add(node.left);
        }
        if (node.right != null) {
          queue.add(node.right);
        }
      }
      ans.add(tmp);
    }

    return ans;
  }

}
