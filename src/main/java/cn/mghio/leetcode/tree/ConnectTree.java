package cn.mghio.leetcode.tree;

/**
 * You are given a perfect binary tree where all leaves are on the same level, and every parent has
 * two children.
 *
 * @author mghio
 * @since 2021-12-25
 */
public class ConnectTree {

  /**
   * You are given a perfect binary tree where all leaves are on the same level, and every parent has
   * two children.
   *
   * @param root the root node
   * @return the connected tree node
   */
  public TreeNode connect(TreeNode root) {
    if (root == null) {
      return null;
    }

    connectTwoNode(root.left, root.right);
    return root;
  }

  private void connectTwoNode(TreeNode node1, TreeNode node2) {
    if (node1 == null || node2 == null) {
      return;
    }

    connectTwoNode(node1.left, node1.right);
    connectTwoNode(node2.left, node2.right);
    connectTwoNode(node1.right, node2.left);
  }

}
