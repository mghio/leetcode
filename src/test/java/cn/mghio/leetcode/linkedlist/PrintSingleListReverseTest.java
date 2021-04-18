package cn.mghio.leetcode.linkedlist;

import org.junit.jupiter.api.Test;

/**
 * @author mghio
 * @since 2021-04-18
 */
public class PrintSingleListReverseTest {

  private final PrintSingleListReverse printSingleListReverse = new PrintSingleListReverse();

  /**
   * 输入的链表为空指针
   */
  @Test
  public void testCase1() {
    printSingleListReverse.printSingleListReverse(null);
  }

  /**
   * 输入的链表只有一个节点
   */
  @Test
  public void testCase2() {
    SingleListNode node = new SingleListNode(9527, null);
    printSingleListReverse.printSingleListReverse(null);
  }

  /**
   * 输入的链表有 3 个节点
   */
  @Test
  public void testCase3() {
    SingleListNode thirdNode = new SingleListNode(3, null);
    SingleListNode secondNode = new SingleListNode(2, thirdNode);
    SingleListNode firstNode = new SingleListNode(1, secondNode);
    printSingleListReverse.printSingleListReverse(firstNode);
  }

}
