package cn.mghio.leetcode.tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Given the root of a binary tree, return all duplicate subtrees.
 *
 * For each kind of duplicate subtrees, you only need to return the root node of any one of them.
 *
 * Two trees are duplicate if they have the same structure with the same node values.
 *
 * @author mghio
 * @since 2022-03-09
 */
public class FindDuplicateSubtrees {

  private static final String NULL_NODE_PLACEHOLDER = "#";
  private static final String SEPARATORS = ",";

  private final List<TreeNode> res = new LinkedList<>();
  private final Map<String, Integer> memo = new HashMap<>();

  public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
    traverse(root);
    return res;
  }

  private String traverse(TreeNode root) {
    if (root == null) {
      return NULL_NODE_PLACEHOLDER;
    }

    String left = traverse(root.left);
    String right = traverse(root.right);
    String subTree = left + SEPARATORS + right + SEPARATORS + root.val;

    int freq = memo.getOrDefault(subTree, 0);
    if (freq == 1) {
      res.add(root);
    }
    memo.put(subTree, freq + 1);

    return subTree;
  }

}
