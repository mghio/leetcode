package cn.mghio.leetcode.tree;

/**
 * Diameter of Binary Tree.
 *
 * @author mghio
 * @since 2022-04-05
 */
public class DiameterOfBinaryTree {

  private int diameter;

  public int diameterOfBinaryTree(TreeNode root) {
    if (root == null) {
      return 1;
    }

    diameter = 1;
    depth(root);
    return diameter - 1;
  }

  private int depth(TreeNode root) {
    if (root == null) {
      return 0;
    }

    int lDepth = depth(root.left);
    int rDepth = depth(root.right);
    diameter = Math.max(diameter, lDepth + rDepth + 1);
    return Math.max(lDepth, rDepth) + 1;
  }

}
