package cn.mghio.leetcode.bst;

/**
 * You are given the root of a binary search tree (BST) and an integer val.
 *
 * @author mghio
 * @since 2022-01-27
 */
public class SearchBST {

  /**
   * You are given the root of a binary search tree (BST) and an integer val.
   *
   * @param root the root node
   * @param target the target value
   * @return the target node
   */
  public TreeNode searchBST(TreeNode root, int target) {
    if (root == null) {
      return null;
    }

    if (root.val == target) {
      return root;
    } else if (root.val > target) {
      return searchBST(root.left, target);
    } else {
      return searchBST(root.right, target);
    }
  }

}
