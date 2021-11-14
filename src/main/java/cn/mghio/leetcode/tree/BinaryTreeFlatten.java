package cn.mghio.leetcode.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Given the root of a binary tree, flatten the tree into a "linked list":
 *
 * - The "linked list" should use the same TreeNode class where the right child pointer points to the
 * next node in the list and the left child pointer is always null.
 * - The "linked list" should be in
 * the same order as a pre-order traversal of the binary tree.
 *
 * @author mghio
 * @since 2021-10-01
 */
public class BinaryTreeFlatten {

  /**
   * Flatten a binary tree.
   *
   * @param root the root node
   */
  public void flatten(TreeNode root) {
    TreeNode curr = root;
    while (curr != null) {
      if (curr.left != null) {
        TreeNode next = curr.left;
        TreeNode predecessor = next;
        while (predecessor.right != null) {
          predecessor = predecessor.right;
        }
        predecessor.right = curr.right;
        curr.left = null;
        curr.right = next;
      }
      curr = curr.right;
    }
  }

  private void flattenBad(TreeNode root) {
    List<TreeNode> list = new ArrayList<>();
    Deque<TreeNode> stack = new LinkedList<>();

    TreeNode node = root;
    while (node != null || !stack.isEmpty()) {
      while (node != null) {
        list.add(node);
        stack.push(node);
        node = node.left;
      }
      node = stack.poll();
      assert node != null;
      node = node.right;
    }

    int size = list.size();
    // skip the root node
    for (int i = 1; i < size; i++) {
      TreeNode prev = list.get(i - 1);
      TreeNode curr = list.get(i);
      prev.left = null;
      prev.right = curr;
    }
  }

}
