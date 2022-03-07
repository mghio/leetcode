package cn.mghio.leetcode.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given the root of a binary tree, imagine yourself standing on the right side of it, return the
 * values of the nodes you can see ordered from top to bottom.
 *
 * @author mghio
 * @since 2022-03-07
 */
public class RightSideView {

  /**
   * Given the root of a binary tree, imagine yourself standing on the right side of it, return the
   * values of the nodes you can see ordered from top to bottom.
   *
   * @param root the root node
   * @return the values of the nodes you can see ordered form top to bottom
   */
  public List<Integer> rightSideView(TreeNode root) {
    List<Integer> res = new LinkedList<>();
    if (root == null) {
      return res;
    }

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      while (size > 0) {
        TreeNode curNode = queue.poll();
        assert curNode != null;
        if (size == 1) {
          res.add(curNode.val);
        }

        if (curNode.left != null) {
          queue.offer(curNode.left);
        }
        if (curNode.right != null) {
          queue.offer(curNode.right);
        }
        size--;
      }
    }

    return res;
  }

}
