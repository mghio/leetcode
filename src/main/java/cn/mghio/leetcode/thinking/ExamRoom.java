package cn.mghio.leetcode.thinking;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * Exam Room.
 *
 * @author mghio
 * @since 2022-03-19
 */
public class ExamRoom {

  private final Map<Integer, int[]> startMap;

  private final Map<Integer, int[]> endMap;

  private final TreeSet<int[]> pq;

  private final int n;

  public ExamRoom(int n) {
    this.n = n;
    startMap = new HashMap<>();
    endMap = new HashMap<>();

    pq = new TreeSet<>((a, b) -> {
      int distA = distance(a);
      int distB = distance(b);
      if (distA == distB) {
        return b[0] - a[0];
      }
      return distA - distB;
    });

    addInterval(new int[]{-1, n});
  }

  public int seat() {
    int[] longest = pq.last();
    int x = longest[0];
    int y = longest[1];

    int seat;
    if (x == -1) {
      seat = 0;
    } else if (y == n) {
      seat = n - 1;
    } else {
      seat = (y - x) / 2 + x;
    }

    int[] left = new int[]{x, seat};
    int[] right = new int[]{seat, y};
    removeInterval(longest);
    addInterval(left);
    addInterval(right);

    return seat;
  }

  public void leave(int p) {
    int[] left = startMap.get(p);
    int[] right = endMap.get(p);
    // merge
    int[] merged = new int[]{left[0], right[1]};
    removeInterval(left);
    removeInterval(right);
    addInterval(merged);
  }

  private void removeInterval(int[] ints) {
    pq.remove(ints);
    startMap.remove(ints[0]);
    endMap.remove(ints[1]);
  }

  private void addInterval(int[] ints) {
    pq.add(ints);
    startMap.put(ints[0], ints);
    endMap.put(ints[1], ints);
  }

  private int distance(int[] a) {
    int x = a[0];
    int y = a[1];

    if (x == -1) {
      return y;
    }
    if (y == n) {
      return n - 1 - x;
    }
    return (y - x) / 2;
  }

}
