package java.cn.mghio.leetcode.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * The thief has found himself a new place for his thievery again. There is only one entrance to
 * this area, called root.
 *
 * Besides the root, each house has one and only one parent house. After a tour, the smart thief
 * realized that all houses in this place form a binary tree. It will automatically contact the
 * police if two directly-linked houses were broken into on the same night.
 *
 * Given the root of the binary tree, return the maximum amount of money the thief can rob without
 * alerting the police.
 *
 * @author mghio
 * @since 2021-11-10
 */
public class RobIII {

  private final Map<TreeNode, Integer> f = new HashMap<>();
  private final Map<TreeNode, Integer> g = new HashMap<>();

  /**
   * Return the maximum amount of money the thief can rob without alerting the police.
   *
   * @param node the node
   * @return the maximum amount of money
   */
  public int rob(TreeNode node) {
    dfs(node);
    return Math.max(f.getOrDefault(node, 0), g.getOrDefault(node, 0));
  }

  private void dfs(TreeNode node) {
    if (node == null) {
      return;
    }

    dfs(node.left);
    dfs(node.right);
    f.put(node, node.val + g.getOrDefault(node.left, 0) + g.getOrDefault(node.right, 0));
    g.put(node, Math.max(f.getOrDefault(node.left, 0), g.getOrDefault(node.left, 0))
        + Math.max(f.getOrDefault(node.right, 0), g.getOrDefault(node.right, 0)));
  }

  public static class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

}
