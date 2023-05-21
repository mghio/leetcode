package cn.mghio.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Path Sum II.
 * <p>
 * Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where the
 * sum of the node values in the path equals targetSum. Each path should be returned as a list of
 * the node values, not node references.
 * <p>
 * A root-to-leaf path is a path starting from the root and ending at any leaf node. A leaf is a
 * node with no children.
 *
 * @author mghio (mghio.dev@gmail.com)
 */
public class PathSum {

  private final List<Integer> path = new ArrayList<>();
  private final List<List<Integer>> paths = new ArrayList<>();
  private int sum = 0;

  public List<List<Integer>> pathSumV1(TreeNode root, int targetSum) {
    if (root == null) {
      return paths;
    }

    if (root.left == null && root.right == null && root.val == targetSum) {
      this.path.add(root.val);
      this.paths.add(this.path);
      return paths;
    }

    this.sum = targetSum;
    this.dfs(root, 0);
    return this.paths;
  }

  private void dfs(TreeNode node, int num) {
    num += node.val;
    this.path.add(node.val);
    if (node.left == null && node.right == null) {
      if (this.sum == num) {
        this.paths.add(new ArrayList<>(this.path));
      }
    }

    if (node.left != null) {
      this.dfs(node.left, num);
    }
    if (node.right != null) {
      this.dfs(node.right, num);
    }
    this.path.remove(this.path.size() - 1);
  }

}
