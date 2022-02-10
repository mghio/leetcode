package cn.mghio.leetcode.backtracking;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Given an array nums of distinct integers, return all the possible permutations. You can return
 * the answer in any order.
 *
 * @author mghio
 * @since 2021-12-19
 */
public class Permute {

  private final List<List<Integer>> res = new LinkedList<>();

  /**
   * Given an array nums of distinct integers, return all the possible permutations.
   *
   * @param nums the nums array
   * @return all the possible permutations
   */
  public List<List<Integer>> permute(int[] nums) {
    if (nums == null || nums.length == 0) {
      return res;
    }

    LinkedList<Integer> track = new LinkedList<>();
    backtrack(nums, track);
    return res;
  }

  private void backtrack(int[] nums, LinkedList<Integer> track) {
    if (nums.length == track.size()) {
      // In Java, parameter passing is by value, and in the process of passing parameters for
      // object type variables, the address of the variable is copied.
      res.add(new ArrayList<>(track));
      return;
    }

    for (int num : nums) {
      // O(N)
      if (track.contains(num)) {
        continue;
      }

      track.add(num);
      backtrack(nums, track);
      track.removeLast();
    }
  }

  /**
   * Given an array nums of distinct integers, return all the possible permutations.
   *
   * @param nums the nums array
   * @return all the possible permutations
   */
  public List<List<Integer>> permuteSolution2(int[] nums) {
    if (nums == null || nums.length == 0) {
      return res;
    }

    boolean[] used = new boolean[nums.length];
    Deque<Integer> path = new ArrayDeque<>();
    dfs(nums, nums.length, 0, path, used, res);
    return res;
  }

  private void dfs(int[] nums, int length, int depth, Deque<Integer> path,
      boolean[] used, List<List<Integer>> res) {
    if (depth == length) {
      res.add(new ArrayList<>(path));
      return;
    }

    for (int i = 0; i < length; i++) {
      if (used[i]) {
        continue;
      }

      path.addLast(nums[i]);
      used[i] = true;
      dfs(nums, length, depth + 1, path, used, res);
      used[i] = false;
      path.removeLast();
    }
  }

}
