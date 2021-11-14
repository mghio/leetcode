package cn.mghio.leetcode.tree;

/**
 * You are given the root node of a binary search tree (BST) and a value to insert into the tree.
 * Return the root node of the BST after the insertion. It is guaranteed that the new value does not
 * exist in the original BST.
 *
 * Notice that there may exist multiple valid ways for the insertion, as long as the tree remains a
 * BST after insertion. You can return any of them.
 *
 * @author mghio
 * @since 2021-10-02
 */
public class InsertIntoBinarySearchTree {

  /**
   * Given the root node of a binary search tree (BST) and a value to insert into the tree.
   *
   * @param root the root node
   * @param val the to insert node val
   * @return the inserted binary search tree root node
   */
  public TreeNode insertIntoBST(TreeNode root, int val) {
    if (root == null) {
      return new TreeNode(val);
    }

    TreeNode node = root;
    while (node != null) {
      if (val > node.val) {
        if (node.right == null) {
          node.right = new TreeNode(val);
          return root;
        }
        node = node.right;
      } else {  // val < node.val
        if (node.left == null) {
          node.left = new TreeNode(val);
          return root;
        }
        node = node.left;
      }
    }
    return root;
  }

}
