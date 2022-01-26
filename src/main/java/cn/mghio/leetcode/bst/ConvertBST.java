package cn.mghio.leetcode.bst;

/**
 * Given the root of a Binary Search Tree (BST), convert it to a Greater Tree such that every key of
 * the original BST is changed to the original key plus the sum of all keys greater than the
 * original key in BST.
 *
 * @author mghio
 * @since 2022-01-26
 */
public class ConvertBST {

  private int sum;

  /**
   * Given the root of a Binary Search Tree (BST), convert it to a Greater Tree such that every key
   * of the original BST is changed to the original key plus the sum of all keys greater than the
   * original key in BST.
   *
   * @param root the root node
   * @return the result
   */
  public TreeNode convertBST(TreeNode root) {
    traverse(root);
    return root;
  }

  private void traverse(TreeNode root) {
    if (root == null) {
      return;
    }

    traverse(root.right);
    sum += root.val;
    root.val = sum;
    traverse(root.left);
  }

}
