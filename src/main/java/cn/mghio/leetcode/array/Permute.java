package cn.mghio.leetcode.array;

import java.util.ArrayList;
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

}
