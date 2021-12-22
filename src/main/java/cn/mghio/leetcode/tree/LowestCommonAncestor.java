package cn.mghio.leetcode.tree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 *
 * @author mghio
 * @since 2021-12-22
 */
public class LowestCommonAncestor {

  private TreeNode ans;

  private final Map<Integer, TreeNode> parent = new HashMap<>();
  private final Set<Integer> visited = new HashSet<>() ;

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

  /**
   * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
   *
   * @param root the root node
   * @param p the p node
   * @param q the q node
   * @return the lowest common ancestor
   */
  public TreeNode lowestCommonAncestorSolution2(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null || p == null || q == null) {
      return null;
    }

    dfs(root);

    while (p != null) {
      visited.add(p.val);
      p = parent.get(p.val);
    }

    while (q != null) {
      if (visited.contains(q.val)) {
        return q;
      }
      q = parent.get(q.val);
    }

    return null;
  }

  private void dfs(TreeNode root) {
    if (root.left != null) {
      parent.put(root.left.val, root);
      dfs(root);
    }

    if (root.right != null) {
      parent.put(root.right.val, root);
      dfs(root);
    }
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
