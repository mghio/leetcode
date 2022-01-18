package cn.mghio.leetcode.list;

/**
 * Definition for singly-linked list.
 *
 * @author mghio
 * @since 2021-10-04
 */
public class SinglyNode implements Comparable<SinglyNode> {

  int val;
  SinglyNode next;

  public SinglyNode(int val) {
    this.val = val;
  }

  public SinglyNode(int val, SinglyNode next) {
    this.val = val;
    this.next = next;
  }

  @Override
  public int compareTo(SinglyNode o) {
    return this.val - o.val;
  }
}
