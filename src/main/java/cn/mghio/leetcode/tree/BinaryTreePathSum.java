package cn.mghio.leetcode.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where the
 * sum of the node values in the path equals targetSum. Each path should be returned as a list of
 * the node values, not node references.
 *
 * @author mghio
 * @since 2021-10-01
 */
public class BinaryTreePathSum {

  private final List<List<Integer>> values = new ArrayList<>();
  private final Deque<Integer> path = new LinkedList<>();

  /**
   * all root-to-leaf paths where the sum of the node values in the path equals targetSum.
   *
   * @param root the root node
   * @param targetSum the target sum
   * @return the all root-to-leaf paths
   */
  public List<List<Integer>> pathSumInDFS(TreeNode root, int targetSum) {
    if (root == null) {
      return values;
    }

    dfs(root, targetSum);
    return values;
  }

  /**
   * all root-to-leaf paths where the sum of the node values in the path equals targetSum.
   *
   * @param root the root node
   * @param targetSum the target sum
   * @return the all root-to-leaf paths
   */
  public List<List<Integer>> pathSumInBFS(TreeNode root, int targetSum) {
    List<List<Integer>> values = new ArrayList<>();
    if (root == null) {
      return values;
    }

    Map<TreeNode, TreeNode> parentMap = new HashMap<>();
    Queue<TreeNode> queueNode = new LinkedList<>();
    Queue<Integer> queueSum = new LinkedList<>();
    queueNode.offer(root);
    queueSum.offer(0);
    while (!queueNode.isEmpty()) {
      TreeNode node = queueNode.poll();
      int rec = queueSum.poll() + node.val;

      if (node.left == null && node.right == null) {
        if (rec == targetSum) {
          List<Integer> paths = new LinkedList<>();
          while (node != null) {
            paths.add(0, node.val);
            node = parentMap.get(node);
          }
          values.add(paths);
        }
      } else {
        if (node.left != null) {
          parentMap.put(node.left, node);
          queueNode.offer(node.left);
          queueSum.offer(rec);
        }

        if (node.right != null) {
          parentMap.put(node.right, node);
          queueNode.offer(node.right);
          queueSum.offer(rec);
        }
      }
    }

    return values;
  }

  private void dfs(TreeNode node, int targetSum) {
    if (node == null) {
      return;
    }

    path.offerLast(node.val);
    targetSum -= node.val;
    if (node.left == null && node.right == null && targetSum == 0) {
      values.add(new LinkedList<>(path));
    }

    dfs(node.left, targetSum);
    dfs(node.right, targetSum);
    path.pollLast();
  }

}
