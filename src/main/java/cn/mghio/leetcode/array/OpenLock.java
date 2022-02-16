package cn.mghio.leetcode.array;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * You have a lock in front of you with 4 circular wheels. Each wheel has 10 slots: '0', '1', '2',
 * '3', '4', '5', '6', '7', '8', '9'. The wheels can rotate freely and wrap around: for example we
 * can turn '9' to be '0', or '0' to be '9'. Each move consists of turning one wheel one slot.
 *
 * @author mghio
 * @since 2022-02-16
 */
public class OpenLock {

  /**
   * You have a lock in front of you with 4 circular wheels. Each wheel has 10 slots: '0', '1', '2',
   * '3', '4', '5', '6', '7', '8', '9'. The wheels can rotate freely and wrap around: for example we
   * can turn '9' to be '0', or '0' to be '9'. Each move consists of turning one wheel one slot.
   */
  public int openLock(String[] deadEnds, String target) {
    Set<String> deads = new HashSet<>();
    Collections.addAll(deads, deadEnds);

    Set<String> visited = new HashSet<>();
    Queue<String> queue = new LinkedList<>();
    int step = 0;
    queue.offer("0000");
    visited.add("0000");

    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        String curr = queue.poll();
        assert curr != null;

        if (deads.contains(curr)) {
          continue;
        }
        if (curr.equals(target)) {
          return step;
        }

        for (int j = 0; j < 4; j++) {
          String up = plusOne(curr, j);
          if (!visited.contains(up)) {
            queue.offer(up);
            visited.add(up);
          }

          String down = minusOne(curr, j);
          if (!visited.contains(down)) {
            queue.offer(down);
            visited.add(down);
          }
        }
      }
      step++;
    }
    return -1;
  }

  private String minusOne(String curr, int j) {
    char[] ch = curr.toCharArray();
    if (ch[j] == '0') {
      ch[j] = '9';
    } else {
      ch[j] -= 1;
    }
    return new String(ch);
  }

  private String plusOne(String curr, int j) {
    char[] ch = curr.toCharArray();
    if (ch[j] == '9') {
      ch[j] = '0';
    } else {
      ch[j] += 1;
    }
    return new String(ch);
  }

}
