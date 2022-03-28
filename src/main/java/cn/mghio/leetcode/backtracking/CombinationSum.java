package cn.mghio.leetcode.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Combination Sum.
 *
 * @author mghio
 * @since 2022-03-28
 */
public class CombinationSum {

  private final List<List<Integer>> ret = new ArrayList<>();

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    if (candidates == null || candidates.length == 0 || target <= 0) {
      return ret;
    }

    LinkedList<Integer> track = new LinkedList<>();
    backtrack(track, candidates, 0, target);
    return ret;
  }

  private void backtrack(LinkedList<Integer> track, int[] candidates, int index, int target) {
    if (index == candidates.length) {
      return;
    }

    if (target == 0) {
      ret.add(new ArrayList<>(track));
      return;
    }

    backtrack(track, candidates, index + 1, target);
    if (target - candidates[index] >= 0) {
      track.addLast(candidates[index]);
      backtrack(track, candidates, index, target - candidates[index]);
      track.removeLast();
    }
  }

}
