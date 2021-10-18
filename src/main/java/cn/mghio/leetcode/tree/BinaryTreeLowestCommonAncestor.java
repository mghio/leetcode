package java.cn.mghio.leetcode.tree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 *
 * @author mghio
 * @since 2021-09-28
 */
public class BinaryTreeLowestCommonAncestor {

  private final Map<Integer, TreeNode> parent = new HashMap<>();
  private final Set<Integer> visited = new HashSet<>();

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

  /**
   * Find the lowest common ancestor.
   *
   * @param root the binary tree root node
   * @param p the node
   * @param q the other node
   * @return the lowest common ancestor
   */
  public TreeNode lowestCommonAncestorSolution2(TreeNode root, TreeNode p, TreeNode q) {
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
      dfs(root.left);
    }

    if (root.right != null) {
      parent.put(root.right.val, root);
      dfs(root.right);
    }
  }

}
