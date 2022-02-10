package cn.mghio.leetcode.backtracking;

import java.util.ArrayList;
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

}
