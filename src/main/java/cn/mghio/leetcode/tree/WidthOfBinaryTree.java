package cn.mghio.leetcode.tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Given the root of a binary tree, return the maximum width of the given tree.
 *
 * @author mghio
 * @since 2022-01-12
 */
public class WidthOfBinaryTree {

  /**
   * Given the root of a binary tree, return the maximum width of the given tree.
   *
   * @param root the root node
   * @return the result
   */
  public int withOfBinaryTreeSolution1(TreeNode root) {
    Queue<Node> queue = new LinkedList<>();
    queue.add(new Node(root, 0, 0));

    int curDepth = 0;
    int left = 0;
    int res = 0;
    while (!queue.isEmpty()) {
      Node node = queue.poll();
      if (node.node != null) {
        queue.add(new Node(node.node.left, node.depth + 1, node.position * 2));
        queue.add(new Node(node.node.right, node.depth + 1, node.position * 2 + 1));
        if (curDepth != node.depth) {
          curDepth = node.depth;
          left = node.position;
        }
        res = Math.max(res, node.position - left + 1);
      }
    }

    return res;
  }

  private int res = 0;
  private Map<Integer, Integer> left = new HashMap<>();

  /**
   * Given the root of a binary tree, return the maximum width of the given tree.
   *
   * @param root the root node
   * @return the result
   */
  public int withOfBinaryTreeSolution2(TreeNode root) {
    dfs(root, 0, 0);
    return res;
  }

  /**
   * Given the root of a binary tree, return the maximum width of the given tree.
   *
   * @param root the root node
   * @return the result
   */
  public int withOfBinaryTreeSolution3(TreeNode root) {
    Queue<Node> queue = new LinkedList<>();
    queue.add(new Node(root, 0, 0));
    int curDepth = 0, left = 0, res = 0;

    while (!queue.isEmpty()) {
      Node node = queue.poll();
      if (node != null) {
        queue.add(new Node(root.left, node.depth + 1, node.position * 2));
        queue.add(new Node(root.right, node.depth + 1, node.position * 2 + 1));
        if (curDepth != node.depth) {
          curDepth = node.depth;
          left = node.position;
        }
        res = Math.max(res, node.position - left + 1);
      }
    }
    return res;
  }

  private void dfs(TreeNode root, int depth, int position) {
    if (root == null) {
      return;
    }

    left.putIfAbsent(depth, position);
    res = Math.max(res, position - left.get(depth) + 1);
    dfs(root.left, depth + 1, position * 2);
    dfs(root.right, depth + 1, position * 2 + 1);
  }

  public static class Node {

    TreeNode node;
    int depth;
    int position;

    public Node(TreeNode node, int depth, int position) {
      this.node = node;
      this.depth = depth;
      this.position = position;
    }
  }

}
