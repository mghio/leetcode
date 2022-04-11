package cn.mghio.leetcode.tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * All Nodes Distance K in Binary Tree.
 *
 * @author mghio
 * @since 2022-04-11
 */
public class DistanceK {

  // <parentNode, curNode>
  private final Map<Integer, TreeNode> parents = new HashMap<>();
  private final List<Integer> ret = new LinkedList<>();

  public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
    if (root == null || target == null) {
      return ret;
    }

    doFindParents(root);
    doFindRet(target, null, 0, k);
    return ret;
  }

  private void doFindRet(TreeNode node, TreeNode from, int depth, int k) {
    if (node == null) {
      return;
    }

    if (depth == k) {
      ret.add(node.val);
      return;
    }

    if (node.left != from) {
      doFindRet(node.left, node, depth + 1, k);
    }
    if (node.right != from) {
      doFindRet(node.right, node, depth + 1, k);
    }
    if (parents.get(node.val) != from) {
      doFindRet(parents.get(node.val), node, depth + 1, k);
    }
  }

  private void doFindParents(TreeNode root) {
    if (root.left != null) {
      parents.put(root.left.val, root);
      doFindParents(root.left);
    }

    if (root.right != null) {
      parents.put(root.right.val, root);
      doFindParents(root.right);
    }
  }

}
