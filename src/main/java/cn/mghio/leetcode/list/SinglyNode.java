package cn.mghio.leetcode.list;

/**
 * Definition for singly-linked list.
 *
 * @author mghio
 * @since 2021-10-04
 */
public class SinglyNode {

  int val;
  SinglyNode next;

  public SinglyNode(int val) {
    this.val = val;
  }

  public SinglyNode(int val, SinglyNode next) {
    this.val = val;
    this.next = next;
  }
}
