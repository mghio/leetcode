package cn.mghio.leetcode.tree;

/**
 * Given the root of a binary tree, invert the tree, and return its root.
 *
 * @author mghio
 * @since 2021-12-25
 */
public class InvertTree {

  /**
   * Given the root of a binary tree, invert the tree, and return its root.
   *
   * @param root the root node
   * @return the inverted tree
   */
  public TreeNode invertTreeSolution1(TreeNode root) {
    if (root == null) {
      return null;
    }

    TreeNode tempNode = root.left;
    root.left = root.right;
    root.right = tempNode;

    invertTreeSolution1(root.left);
    invertTreeSolution1(root.right);

    return root;
  }

  /**
   * Given the root of a binary tree, invert the tree, and return its root.
   *
   * @param root the root node
   * @return the inverted tree
   */
  public TreeNode invertTreeSolution2(TreeNode root) {
    if (root == null) {
      return null;
    }

    TreeNode right = invertTreeSolution2(root.left);
    TreeNode left = invertTreeSolution2(root.right);

    root.right = right;
    root.left = left;

    return root;
  }

  private void swap(TreeNode root) {
    TreeNode tmp = root.left;
    root.left = root.right;
    root.right = tmp;
  }

}
