package cn.mghio.leetcode.tree;

/**
 * Given the root of a complete binary tree, return the number of the nodes in the tree.
 *
 * @author mghio
 * @since 2021-12-25
 */
public class CountNodes {

  /**
   * Given the root of a complete binary tree, return the number of the nodes in the tree.
   *
   * @param root the root node
   * @return the number of the nodes in the tree
   */
  public int countNodesSolution1(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return countNodesSolution1(root.left) + countNodesSolution1(root.right) + 1;
  }

}
