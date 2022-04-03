package cn.mghio.leetcode.tree;

/**
 * Merge Two Binary Trees.
 *
 * @author mghio
 * @since 2022-04-03
 */
public class MergeTrees {

  public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
    if (root1 == null || root2 == null) {
      return root1 == null ? root2 : root1;
    }

    TreeNode newNode = new TreeNode(root1.val + root2.val);
    newNode.left = mergeTrees(root1.left, root2.left);
    newNode.right = mergeTrees(root1.right, root2.right);
    return newNode;
  }

}
