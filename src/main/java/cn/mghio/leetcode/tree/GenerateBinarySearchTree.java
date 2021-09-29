package java.cn.mghio.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer n, return all the structurally unique BST's (binary search trees), which has
 * exactly n nodes of unique values from 1 to n. Return the answer in any order.
 *
 * @author mghio
 * @since 2021-09-28
 */
public class GenerateBinarySearchTree {

  /**
   * Given a number, generate all binary search trees.
   *
   * @param n the number
   * @return the all binary search trees
   */
  public List<TreeNode> generateTrees(int n) {
    if (n < 1) {
      return new ArrayList<>();
    }

    return generateTrees(1, n);
  }

  private List<TreeNode> generateTrees(int start, int end) {
    List<TreeNode> trees = new ArrayList<>();

    if (start > end) {
      trees.add(null);
      return trees;
    }

    for (int i = start; i <= end; i++) {
      List<TreeNode> leftSubTrees = generateTrees(start, i - 1);
      List<TreeNode> rightSubTrees = generateTrees(i + 1, end);

      for (TreeNode rightTree : rightSubTrees) {
        for (TreeNode leftTree : leftSubTrees) {
          TreeNode node = new TreeNode(i);
          node.right = rightTree;
          node.left = leftTree;
          trees.add(node);
        }
      }
    }

    return trees;
  }

}
