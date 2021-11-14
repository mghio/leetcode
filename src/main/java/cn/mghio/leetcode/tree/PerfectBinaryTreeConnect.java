package cn.mghio.leetcode.tree;

/**
 * You are given a perfect binary tree where all leaves are on the same level, and every parent has
 * two children. The binary tree has the following definition:
 *
 * @author mghio
 * @since 2021-09-28
 */
public class PerfectBinaryTreeConnect {

  /**
   * Connect prefect binary tree.
   *
   * @param root the root node
   * @return connected prefect binary tree root node
   */
  public Node connect(Node root) {
    if (root != null) {
      dfs(root.left, root.right);
    }

    return root;
  }

  private void dfs(Node left, Node right) {
    if (left == null || left.next == right) {
      return;
    }

    left.next = right;
    dfs(left.left, left.right);
    dfs(left.right, right.left);
    dfs(right.left, right.right);
  }

}
