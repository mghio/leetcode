package cn.mghio.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Please complete a function, input a binary tree, and the function outputs its mirror.
 *
 * @author mghio
 * @since 2021-09-29
 */
public class BinaryTreeMirror {

  /**
   *  input a binary tree, and the function outputs its mirror.
   *
   * @param root the binary tree root node
   * @return the mirror binary tree
   */
  public TreeNode mirrorTree(TreeNode root) {
    if (root == null) {
      return null;
    }

    if (root.left == null && root.right == null) {
      return root;
    }

    TreeNode tmpNode = root.left;
    root.left = root.right;
    root.right = tmpNode;

    if (root.left != null) {
      mirrorTree(root.left);
    }

    if (root.right != null) {
      mirrorTree(root.right);
    }

    return root;
  }

  private List<TreeNode> numBinarySearchTree(int start, int end) {
    List<TreeNode> allTrees = new ArrayList<>();

    if (start > end) {
      allTrees.add(null);
      return allTrees;
    }

    for (int i = start; i <= end; i++) {
      List<TreeNode> leftSubTrees = numBinarySearchTree(start, i - 1);
      List<TreeNode> rightSubTrees = numBinarySearchTree(i + 1, end);

      for (TreeNode leftTree : leftSubTrees) {
        for (TreeNode rightTree : rightSubTrees) {
          TreeNode node = new TreeNode(i);
          node.left = leftTree;
          node.right = rightTree;
          allTrees.add(node);
        }
      }
    }

    return allTrees;
  }

}
