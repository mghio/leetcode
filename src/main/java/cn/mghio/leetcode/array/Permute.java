package cn.mghio.leetcode.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Permutations.
 *
 * Given an array nums of distinct integers, return all the possible permutations. You can return
 * the answer in any order.
 *
 * @author mghio
 * @since 2022-03-27
 */
public class Permute {

  private final List<List<Integer>> ret = new ArrayList<>();

  public List<List<Integer>> permute(int[] nums) {
    if (nums == null || nums.length == 0) {
      return ret;
    }

    List<Integer> track = new LinkedList<>();
    backtrack(nums, track);
    return ret;
  }

  private void backtrack(int[] nums, List<Integer> track) {
    if (nums.length == track.size()) {
      ret.add(track);
      return;
    }

    for (int num : nums) {
      if (track.contains(num)) {
        continue;
      }
      track.add(num);
      backtrack(nums, track);
      track.remove(track.size() - 1);
    }
  }

  /*--------------------------------------- Solution 2 ------------------------------------------*/

  public List<List<Integer>> permute2(int[] nums) {
    if (nums == null || nums.length == 0) {
      return ret;
    }

    LinkedList<Integer> track = new LinkedList<>();
    backtrack2(nums, track);
    return ret;
  }

  private void backtrack2(int[] nums, LinkedList<Integer> track) {
    if (nums.length == track.size()) {
      ret.add(track);
      return;
    }

    for (int num : nums) {
      if (track.contains(num)) {
        continue;
      }
      track.add(num);
      backtrack(nums, track);
      track.removeLast();
    }
  }

  /*--------------------------------------- Solution 3 ------------------------------------------*/

  public List<List<Integer>> permute3(int[] nums) {
    if (nums == null || nums.length == 0) {
      return ret;
    }

    List<Integer> output = new ArrayList<>();
    for (int num : nums) {
      output.add(num);
    }

    int cnt = nums.length;
    backtrack(0, cnt, output);
    return ret;
  }

  private void backtrack(int first, int n, List<Integer> output) {
    if (first == n) {
      ret.add(new LinkedList<>(output));
      return;
    }

    for (int i = first; i < n; i++) {
      Collections.swap(output, first, i);
      backtrack(first + 1, n, output);
      Collections.swap(output, first, i);
    }
  }

}
