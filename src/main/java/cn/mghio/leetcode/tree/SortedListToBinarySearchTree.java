package java.cn.mghio.leetcode.tree;

/**
 * Given the head of a singly linked list where elements are sorted in ascending order, convert it
 * to a height balanced BST.
 *
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of
 * the two subtrees of every node never differ by more than 1.
 *
 * @author mghio
 * @since 2021-10-01
 */
public class SortedListToBinarySearchTree {

  /**
   * Convert sorted singly-linked list to binary search tree(BST).
   *
   * @param head the head node of singly-linked list
   * @return the root node of binary tree
   */
  public TreeNode sortedListToBST(SinglyLinkedListNode head) {
    return buildBinaryTree(head, null);
  }

  private TreeNode buildBinaryTree(SinglyLinkedListNode left, SinglyLinkedListNode right) {
    if (left == right) {
      return null;
    }

    SinglyLinkedListNode midNode = getMiddleNode(left, right);
    TreeNode root = new TreeNode(midNode.val);
    root.left = buildBinaryTree(left, midNode);
    root.right = buildBinaryTree(midNode.next, right);
    return root;
  }

  private SinglyLinkedListNode getMiddleNode(SinglyLinkedListNode left, SinglyLinkedListNode right) {
    SinglyLinkedListNode fast = left;
    SinglyLinkedListNode slow = left;
    while (fast != right && fast.next != right) {
      fast = fast.next.next;
      slow = slow.next;
    }
    return slow;
  }

}
