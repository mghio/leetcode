package cn.mghio.leetcode.tree;

/**
 * Given the root of a Binary Search Tree (BST), convert it to a Greater Tree such that every key of
 * the original BST is changed to the original key plus the sum of all keys greater than the
 * original key in BST.
 *
 * @author mghio
 * @since 2021-12-08
 */
public class ConvertBST {

  private int sum = 0;

  public TreeNode convertBST(TreeNode root) {
    traverse(root);
    return root;
  }

  public void traverse(TreeNode node) {
    if (node == null) {
      return;
    }
    traverse(node.right);
    sum += node.val;
    node.val = sum;
    traverse(node.left);
  }

}
