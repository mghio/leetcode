package cn.mghio.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the root of a binary tree, flatten the tree into a "linked list".
 *
 * @author mghio
 * @since 2021-12-25
 */
public class Flatten {

  /**
   * Given the root of a binary tree, flatten the tree into a "linked list".
   *
   * @param root the root node
   */
  public void flattenSolution1(TreeNode root) {
    if (root == null) {
      return;
    }

    flattenSolution1(root.left);
    flattenSolution1(root.right);

    TreeNode left = root.left;
    TreeNode right = root.right;

    root.left = null;
    root.right = left;

    TreeNode p = root;
    while (p.right != null) {
      p = p.right;
    }
    p.right = right;
  }

  private final List<TreeNode> preOrderNodes = new ArrayList<>();

  /**
   * Given the root of a binary tree, flatten the tree into a "linked list".
   *
   * @param root the root node
   */
  public void flattenSolution2(TreeNode root) {
    if (root == null) {
      return;
    }

    preOrderTraversal(root, preOrderNodes);

    for (int i = 1, len = preOrderNodes.size(); i < len; i++) {
      TreeNode pre = preOrderNodes.get(i - 1);
      TreeNode cur = preOrderNodes.get(i);
      pre.left = null;
      pre.right = cur;
    }
  }

  private void preOrderTraversal(TreeNode node, List<TreeNode> preOrderNodes) {
    if (node != null) {
      preOrderNodes.add(node);
      preOrderTraversal(node.left, preOrderNodes);
      preOrderTraversal(node.right, preOrderNodes);
    }

  }

}
