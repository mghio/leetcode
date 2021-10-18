package java.cn.mghio.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the
 * BST.
 *
 * @author mghio
 * @since 2021-10-18
 */
public class BinarySearchTreeLowestCommonAncestor {

  /**
   * Find the lowest common ancestor of two given nodes int th binary search tree(BST).
   *
   * @param root the root node
   * @param p the node
   * @param q the other node
   * @return the lowest common ancestor
   */
  public TreeNode lowestCommonAncestorUseIterationTwo(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null || p == null || q == null) {
      return null;
    }

    List<TreeNode> pathP = getPath(root, p);
    List<TreeNode> pathQ = getPath(root, q);

    TreeNode ancestor = null;
    for (int i = 0; i < pathP.size() && i < pathQ.size(); i++) {
      if (pathP.get(i).val == pathQ.get(i).val) {
        ancestor = pathP.get(i);
      } else {
        break;
      }
    }

    return ancestor;
  }

  /**
   * Find the lowest common ancestor of two given nodes int th binary search tree(BST).
   *
   * @param root the root node
   * @param p the node
   * @param q the other node
   * @return the lowest common ancestor
   */
  public TreeNode lowestCommonAncestorUseIterationOne(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null || p == null || q == null) {
      return null;
    }

    TreeNode ancestor = root;
    while (true) {
      if (ancestor.val > p.val && ancestor.val > q.val) {
        ancestor = ancestor.left;
      } else if (ancestor.val < p.val && ancestor.val < q.val) {
        ancestor = ancestor.right;
      } else {
        break;
      }
    }

    return ancestor;
  }

  private List<TreeNode> getPath(TreeNode root, TreeNode target) {
    List<TreeNode> paths = new ArrayList<>();
    TreeNode node = root;
    while (node.val != target.val) {
      paths.add(node);
      if (node.val < target.val) {
        node = node.right;
      } else {
        node = node.left;
      }
    }
    paths.add(node);
    return paths;
  }

}
