package cn.mghio.leetcode.tree;

/**
 * Definition for singly-linked list node.
 *
 * @author mghio
 * @since 2021-10-01
 */
public class SinglyLinkedListNode {

  int val;
  SinglyLinkedListNode next;

  public SinglyLinkedListNode(int val) {
    this.val = val;
  }

  public SinglyLinkedListNode(int val, SinglyLinkedListNode next) {
    this.val = val;
    this.next = next;
  }
}
