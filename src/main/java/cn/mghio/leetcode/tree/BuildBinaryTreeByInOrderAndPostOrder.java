package cn.mghio.leetcode.tree;

/**
 * Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary
 * tree and postorder is the postorder traversal of the same tree, construct and return the binary
 * tree.
 *
 * @author mghio
 * @since 2021-09-27
 */
public class BuildBinaryTreeByInOrderAndPostOrder {

  /**
   * build binary tree by in order and post order.
   *
   * @param inOrder the in order
   * @param postOrder the post order
   * @return the root node
   */
  public TreeNode buildTree(int[] inOrder, int[] postOrder) {
    if (inOrder == null || postOrder == null
        || inOrder.length == 0 || postOrder.length == 0
        || inOrder.length != postOrder.length) {
      return null;
    }

    int len = inOrder.length;
    return buildTreeDFS(inOrder, 0, len - 1,
                        postOrder, 0, len - 1);
  }

  private TreeNode buildTreeDFS(int[] inOrder, int startLeft, int endLeft,
                                int[] postOrder, int startRight, int endRight) {
    if (startRight > endRight) {
      return null;
    }

    int val = postOrder[endRight];
    TreeNode root = new TreeNode(val);
    if (startRight == endRight) {
      return root;
    }

    int mid = 0;
    while (inOrder[startLeft + mid] != val) {
      mid++;
    }

    root.left = buildTreeDFS(inOrder, startLeft, startLeft + mid - 1,
                             postOrder, startRight, startRight + mid - 1);

    root.right = buildTreeDFS(inOrder, startLeft + mid + 1, endLeft,
                              postOrder, startRight + mid, endRight - 1);

    return root;
  }

}
