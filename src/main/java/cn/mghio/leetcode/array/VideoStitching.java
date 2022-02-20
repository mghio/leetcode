package cn.mghio.leetcode.array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * You are given a series of video clips from a sporting event that lasted time seconds. These video
 * clips can be overlapping with each other and have varying lengths.
 *
 * Each video clip is described by an array clips where clips[i] = [starti, endi] indicates that the
 * ith clip started at starti and ended at endi.
 *
 * We can cut these clips into segments freely.
 *
 * For example, a clip [0, 7] can be cut into segments [0, 1] + [1, 3] + [3, 7]. Return the minimum
 * number of clips needed so that we can cut the clips into segments that cover the entire sporting
 * event [0, time]. If the task is impossible, return -1.
 *
 * @author mghio
 * @since 2022-02-20
 */
public class VideoStitching {

  public int videoStitching(int[][] clips, int time) {
    if (time == 0) {
      return 0;
    }

    Arrays.sort(clips, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        if (o1[0] == o2[0]) {
          return Integer.compare(o2[1], o1[1]);
        }
        return Integer.compare(o1[0], o2[0]);
      }
    });

    int count = 0;
    int curEnd = 0;
    int nextEnd = 0;
    int i = 0;
    int n = clips.length;

    while (i < n && clips[i][0] <= curEnd) {
      while (i < n && clips[i][0] <= curEnd) {
        nextEnd = Math.max(nextEnd, clips[i][1]);
        i++;
      }
      count++;
      curEnd = nextEnd;
      if (curEnd>= time) {
        return count;
      }
    }

    return -1;
  }

}
