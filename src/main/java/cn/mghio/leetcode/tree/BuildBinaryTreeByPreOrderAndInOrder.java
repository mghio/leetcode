package cn.mghio.leetcode.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two integer arrays preorder and inorder where preorder is the preorder traversal of a
 * binary tree and inorder is the inorder traversal of the same tree, construct and return the
 * binary tree.
 *
 * @author mghio
 * @since 2021-12-27
 */
public class BuildBinaryTreeByPreOrderAndInOrder {

  // inorder： <value, index>
  private final Map<Integer, Integer> indexMap = new HashMap<>();

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
    if (preOrder == null || preOrder.length == 0) {
      return null;
    }

    int len = inOrder.length;
    for (int i = 0; i < len; i++) {
      indexMap.put(inOrder[i], i);
    }

    return buildTree(preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length - 1);
  }

  private TreeNode buildTree(int[] preOrder, int preStart, int preEnd,
                             int[] inOrder, int inStart, int inEnd) {
    if (preStart > preEnd) {
      return null;
    }

    int rootVal = preOrder[preStart];
    int rootIndexOfInOrder = indexMap.get(rootVal);

    int leftTreeSize = rootIndexOfInOrder - inStart;
    TreeNode root = new TreeNode(rootVal);
    root.left = buildTree(preOrder, preStart + 1, preStart + leftTreeSize, inOrder, inStart, rootIndexOfInOrder - 1);
    root.right = buildTree(preOrder, preStart + leftTreeSize + 1, preEnd, inOrder, rootIndexOfInOrder + 1, inEnd);
    return root;
  }

}
