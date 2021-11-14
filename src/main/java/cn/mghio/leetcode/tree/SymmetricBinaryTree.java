package cn.mghio.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around
 * its center).
 *
 * @author mghio
 * @since 2021-09-26
 */
public class SymmetricBinaryTree {

  /**
   * judge the binary tree is symmetric use recursion.
   *
   * @param root the three root node
   * @return true is symmetric tree, else false
   */
  public boolean isSymmetricInRecursion(TreeNode root) {
    return checkInRecursion(root, root);
  }

  /**
   * judge the binary tree is symmetric use iteration.
   *
   * @param root the three root node
   * @return true is symmetric tree, else false
   */
  public boolean isSymmetricInIteration(TreeNode root) {
    return checkInIteration(root, root);
  }

  private boolean checkInIteration(TreeNode p, TreeNode q) {
    Queue<TreeNode> nodeQueue = new LinkedList<>();
    nodeQueue.offer(p);
    nodeQueue.offer(q);

    while (!nodeQueue.isEmpty()) {
      p = nodeQueue.poll();
      q = nodeQueue.poll();
      if (p == null && q == null) {
        continue;
      }
      if ((p == null || q == null) || (p.val != q.val)) {
        return false;
      }

      // reverse order offer to queue
      nodeQueue.offer(p.left);
      nodeQueue.offer(q.right);

      nodeQueue.offer(p.right);
      nodeQueue.offer(q.left);
    }

    return true;
  }

  private boolean checkInRecursion(TreeNode p, TreeNode q) {
    if (p == null && q == null) {
      return true;
    }

    if (p == null || q == null) {
      return false;
    }

    return p.val == q.val
        && checkInRecursion(p.left, q.right)
        && checkInRecursion(p.right, q.left);
  }

}
