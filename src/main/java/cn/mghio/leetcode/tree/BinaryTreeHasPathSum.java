package java.cn.mghio.leetcode.tree;

/**
 * Given the root of a binary tree and an integer targetSum, return true if the tree has a
 * root-to-leaf path such that adding up all the values along the path equals targetSum.
 *
 * @author mghio
 * @since 2021-09-27
 */
public class BinaryTreeHasPathSum {

  /**
   * binary tree has path sum.
   *
   * @param root the root node
   * @param targetSum the target sum
   * @return true has path sum, else false
   */
  public boolean hasPathSum(TreeNode root, int targetSum) {
    if (root == null) {
      return false;
    }

    if (root.left == null && root.right == null) {
      return root.val == targetSum;
    }

    boolean leftNodeHasPathSum = hasPathSum(root.left, targetSum - root.val);
    boolean rightNodeHashPathSum = hasPathSum(root.right, targetSum - root.val);
    return leftNodeHasPathSum || rightNodeHashPathSum;
  }

}
