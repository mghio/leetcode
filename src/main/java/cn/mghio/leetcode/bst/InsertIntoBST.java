package cn.mghio.leetcode.bst;

/**
 * You are given the root node of a binary search tree (BST) and a value to insert into the tree.
 * Return the root node of the BST after the insertion. It is guaranteed that the new value does not
 * exist in the original BST.
 *
 * @author mghio
 * @since 2022-01-27
 */
public class InsertIntoBST {

  /**
   * You are given the root node of a binary search tree (BST) and a value to insert into the tree.
   * Return the root node of the BST after the insertion. It is guaranteed that the new value does
   * not exist in the original BST.
   *
   * @param root the root node
   * @param target the target value
   * @return the result
   */
  public TreeNode insertIntoBST(TreeNode root, int target) {
    if (root == null) {
      return new TreeNode(target);
    }

    if (root.val < target) {
      root.right = insertIntoBST(root.right, target);
    }

    if (root.val > target) {
      root.left = insertIntoBST(root.left, target);
    }

    return root;
  }

}
