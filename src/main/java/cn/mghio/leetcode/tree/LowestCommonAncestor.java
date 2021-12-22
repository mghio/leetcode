package cn.mghio.leetcode.tree;

/**
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 *
 * @author mghio
 * @since 2021-12-22
 */
public class LowestCommonAncestor {

  private TreeNode ans;

  /**
   * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
   *
   * @param root the root node
   * @param p the p node
   * @param q the q node
   * @return the lowest common ancestor
   */
  public TreeNode lowestCommonAncestorSolution1(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null || p == null || q == null) {
      return null;
    }

    this.dfs(root, p, q);
    return ans;
  }

  private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null) {
      return false;
    }

    boolean l = dfs(root.left, p, q);
    boolean r = dfs(root.right, p, q);

    if ((l && r) || ((root.val == p.val || root.val == q.val) && (l || r))) {
      ans = root;
    }

    return l || r || (root.val == p.val || root.val == q.val);
  }

}
