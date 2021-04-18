package cn.mghio.leetcode.linkedlist;

/**
 * 单向链表
 *
 * @author mghio
 * @since 2021-04-18
 */
public class SingleListNode {

  private Integer value;

  private SingleListNode next;

  public SingleListNode() {
  }

  public SingleListNode(Integer value, SingleListNode next) {
    this.value = value;
    this.next = next;
  }

  public Integer getValue() {
    return value;
  }

  public void setValue(Integer value) {
    this.value = value;
  }

  public SingleListNode getNext() {
    return next;
  }

  public void setNext(SingleListNode next) {
    this.next = next;
  }
}
