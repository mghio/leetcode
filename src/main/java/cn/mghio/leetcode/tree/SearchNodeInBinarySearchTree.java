package java.cn.mghio.leetcode.tree;

/**
 * You are given the root of a binary search tree (BST) and an integer val.
 *
 * @author mghio
 * @since 2021-09-30
 */
public class SearchNodeInBinarySearchTree {

  /**
   * find the node in binary search tree.
   *
   * @param root the root node
   * @param val the node val
   * @return the node
   */
  public TreeNode find(TreeNode root, int val) {
    if (root == null) {
      return null;
    }

    TreeNode node = root;
    while (node != null) {
      if (node.val == val) {
        return node;
      } else if (node.val > val) {
        node = node.left;
      } else {
        node = node.right;
      }
    }

    return null;
  }

}
