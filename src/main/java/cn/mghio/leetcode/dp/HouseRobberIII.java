package cn.mghio.leetcode.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * The thief has found himself a new place for his thievery again. There is only one entrance to
 * this area, called root.
 *
 * Besides the root, each house has one and only one parent house. After a tour, the smart thief
 * realized that all houses in this place form a binary tree. It will automatically contact the
 * police if two directly-linked houses were broken into on the same night.
 *
 * Given the root of the binary tree, return the maximum amount of money the thief can rob without
 * alerting the police.
 *
 * @author mghio
 * @since 2022-03-14
 */
public class HouseRobberIII {

  private final Map<TreeNode, Integer> memo = new HashMap<>();

  public int rob(TreeNode root) {
    if (root == null) {
      return 0;
    }

    if (memo.containsKey(root)) {
      return memo.get(root);
    }

    int doIt = root.val
        + (root.left == null ? 0 : rob(root.left.left) + rob(root.left.right))
        + (root.right == null ? 0 : rob(root.right.left) + rob(root.right.right));
    int notDo = rob(root.left) + rob(root.right);
    int res = Math.max(doIt, notDo);
    memo.put(root, res);
    return res;
  }

  public int robSolution2(TreeNode root) {
    if (root == null) {
      return 0;
    }

    int[] res = dp(root);
    return Math.max(res[0], res[1]);
  }

  /**
   * @param root the root node
   * @return returns an array of size 2.
   *         arr[0] means the maximum amount of money you will get if you don't rob the root.
   *         arr[1] means the maximum amount of money you will get if you rob the root.
   */
  private int[] dp(TreeNode root) {
    if (root == null) {
      return new int[]{0, 0};
    }

    int[] left = dp(root.left);
    int[] right = dp(root.right);
    // Don’t rob it, you can rob the next home or not, depending on the amount money of the income
    int notRobAmount = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
    // Rob it, you can't rob it next time
    int robAmount = root.val + left[0] + right[0];
    return new int[]{notRobAmount, robAmount};
  }

}
