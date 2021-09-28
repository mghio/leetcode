package java.cn.mghio.leetcode.tree;

/**
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 *
 * @author mghio
 * @since 2021-09-28
 */
public class BinaryTreeLowestCommonAncestor {

  /**
   * Find the lowest common ancestor.
   *
   * @param root the binary tree root node
   * @param p the node
   * @param q the other node
   * @return the lowest common ancestor
   */
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null || p.val == root.val || q.val == root.val) {
      return root;
    }

    TreeNode left = lowestCommonAncestor(root.left, p, q);
    TreeNode right = lowestCommonAncestor(root.right, p, q);

    if (left == null) {
      return right;
    }
    if (right == null) {
      return left;
    }

    return root;
  }

}
