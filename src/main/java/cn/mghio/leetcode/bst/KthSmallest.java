package cn.mghio.leetcode.bst;

/**
 * Given the root of a binary search tree, and an integer k, return the kth smallest value
 * (1-indexed) of all the values of the nodes in the tree.
 *
 * @author mghio
 * @since 2022-01-25
 */
public class KthSmallest {

  private int res = 0;

  private int rank = 0;

  /**
   * Given the root of a binary search tree, and an integer k, return the kth smallest value
   * (1-indexed) of all the values of the nodes in the tree.
   *
   * @param root the root node
   * @param k the kth smallest
   * @return the kth smallest value (1-indexed) of all the values of the nodes in the tree
   */
  public int kthSmallest(TreeNode root, int k) {
    traverse(root, k);
    return res;
  }

  private void traverse(TreeNode root, int k) {
    if (root == null) {
      return;
    }

    traverse(root.left, k);

    rank++;
    if (rank == k) {
      res = root.val;
      return;
    }

    traverse(root.right, k);
  }

}
