package cn.mghio.leetcode.tree;

/**
 * Given a root node reference of a BST and a key, delete the node with the given key in the BST.
 * Return the root node reference (possibly updated) of the BST.
 *
 * @author mghio
 * @since 2021-10-02
 */
public class DeleteBinarySearchTreeNode {

  /**
   * Delete a node with a given value from the binary search tree.
   *
   * @param root the root node
   * @param val the node value
   * @return the deleted BST root node
   */
  public TreeNode deleteNode(TreeNode root, int val) {
    if (root == null) {
      return null;
    }

    // delete from the right subtree
    if (val > root.val) {
      root.right = deleteNode(root.right, val);
    } else if (val < root.val) {
      // delete from the left subtree
      root.left = deleteNode(root.left, val);
    } else {
      // delete the current tree，the node is leaf node
      if (root.left == null && root.right == null) {
        root = null;
      } else if (root.left != null) {
        // not a leaf and has no right child and has a left child
        root.val = predecessor(root);
        root.left = deleteNode(root.left, root.val);
      } else {
        // not a leaf and has a left child and has no right child
        root.val = successor(root);
        root.right = deleteNode(root.right, root.val);
      }
    }

    return root;
  }

  private int successor(TreeNode root) {
    TreeNode node = root.right;
    while (node.right != null) {
      node = node.left;
    }
    return node.val;
  }

  private int predecessor(TreeNode root) {
    TreeNode node = root.left;
    while (node.right != null) {
      node = node.right;
    }
    return node.val;
  }

}
