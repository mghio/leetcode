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

  private Map<TreeNode, Integer> memo = new HashMap<>();

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

}
