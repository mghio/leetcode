package cn.mghio.leetcode.thinking;

/**
 * You are playing the following Nim Game with your friend:
 *
 * - Initially, there is a heap of stones on the table.
 * - You and your friend will alternate taking turns, and you go first.
 * - On each turn, the person whose turn it is will remove 1 to 3 stones from the heap.
 * - The one who removes the last stone is the winner.
 *
 * Given n, the number of stones in the heap, return true if you can win the game assuming both
 * you and your friend play optimally, otherwise return false.
 *
 * @author mghio
 * @since 2022-03-15
 */
public class CanWinNim {

  /**
   * Can win nim.
   *
   * @param n the number of stones in the heap
   * @return return true if you can win the game assuming both you and your friend play optimally,
   * otherwise return false.
   */
  public boolean canWinNim(int n) {
    return n % 4 != 0;
  }

}
