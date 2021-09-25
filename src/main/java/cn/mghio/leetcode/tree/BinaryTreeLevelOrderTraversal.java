package java.cn.mghio.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Binary tree level order traversal.
 *
 * Given the root of a binary tree, return the level order traversal of its nodes' values.
 *
 * @author mghio
 * @since 2021-09-25
 */
public class BinaryTreeLevelOrderTraversal {

  /**
   * level order traversal binary tree.
   *
   * @param root the root node
   * @return tree node values
   */
  public List<List<Integer>> levelOrderTraversal(TreeNode root) {
    if (root == null) {
      return new ArrayList<>();
    }

    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    List<List<Integer>> values = new ArrayList<>();
    while (queue.size() > 0) {
      int size = queue.size();
      List<Integer> levelValues = new ArrayList<>();
      for (int i = 0; i < size; i++) {
        TreeNode curNode = queue.poll();
        assert curNode != null;
        levelValues.add(curNode.val);
        if (curNode.left != null) {
          queue.add(curNode.left);
        }
        if (curNode.right != null) {
          queue.add(curNode.right);
        }
      }
      values.add(levelValues);
    }

    return values;
  }

}
