package cn.mghio.leetcode.tree;

/**
 * Given two integer arrays preorder and inorder where preorder is the preorder traversal of a
 * binary tree and inorder is the inorder traversal of the same tree, construct and return the
 * binary tree.
 *
 * @author mghio
 * @since 2021-12-27
 */
public class BuildBinaryTreeByPreOrderAndInOrder {

  /**
   * Given two integer arrays preorder and inorder where preorder is the preorder traversal of a
   * binary tree and inorder is the inorder traversal of the same tree, construct and return the
   * binary tree.
   *
   * @param preOrder the preorder
   * @param inOrder the inorder
   * @return the binary tree
   */
  public TreeNode buildTree(int[] preOrder, int[] inOrder) {
    return buildTree(preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length - 1);
  }

  private TreeNode buildTree(int[] preOrder, int preStart, int preEnd,
                             int[] inOrder, int inStart, int inEnd) {
    if (preStart > preEnd) {
      return null;
    }

    int rootVal = preOrder[preStart];
    int rootIndexOfInOrder = -1;

    for (int i = inStart; i <= inEnd; i++) {
      if (inOrder[i] == rootVal) {
        rootIndexOfInOrder = i;
        break;
      }
    }

    int leftTreeSize = rootIndexOfInOrder - inStart;
    TreeNode root = new TreeNode(rootVal);
    root.left = buildTree(preOrder, preStart + 1, preStart + leftTreeSize, inOrder, inStart, rootIndexOfInOrder - 1);
    root.right = buildTree(preOrder, preStart + leftTreeSize + 1, preEnd, inOrder, rootIndexOfInOrder + 1, inEnd);
    return root;
  }

}
