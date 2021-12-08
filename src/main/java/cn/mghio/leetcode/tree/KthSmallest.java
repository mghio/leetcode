package cn.mghio.leetcode.tree;

/**
 * Given the root of a binary search tree, and an integer k, return the kth the smallest value
 * (1-indexed) of all the values of the nodes in the tree.
 *
 * @author mghio
 * @since 2021-12-08
 */
public class KthSmallest {

  private int res;
  private int rank = 0;

  /**
   * Return the kth the smallest value(1-indexed) of all the values of the nodes in the tree.
   *
   * @param root the root node
   * @param k the k
   * @return the kth the small value
   */
  public int kthSmallest(TreeNode root, int k) {
    traverse(root, k);
    return res;
  }

  private void traverse(TreeNode node, int k) {
    if (node == null) {
      return;
    }

    traverse(node.left, k);

    rank++;
    if (rank == k) {
      res = node.val;
    }

    traverse(node.right, k);
  }

}
