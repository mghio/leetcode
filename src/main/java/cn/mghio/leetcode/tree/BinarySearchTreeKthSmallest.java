package cn.mghio.leetcode.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * Given the root of a binary search tree, and an integer k, return the kth smallest value
 * (1-indexed) of all the values of the nodes in the tree.
 *
 * @author mghio
 * @since 2021-10-02
 */
public class BinarySearchTreeKthSmallest {

  /**
   *  Get the kth smallest value from the binary search tree.
   *
   * @param root the root node
   * @param k kth node val
   * @return the kth node val
   */
  public int kthSmallest(TreeNode root, int k) {
    List<Integer> values = inOrder(root);
    if (values.isEmpty()) {
      return 0;
    }

    return values.get(k - 1);
  }

  private List<Integer> inOrder(TreeNode root) {
    List<Integer> ret = new LinkedList<>();
    if (root == null) {
      return ret;
    }

    ret.addAll(inOrder(root.left));
    ret.add(root.val);
    ret.addAll(inOrder(root.right));

    return ret;
  }

}
