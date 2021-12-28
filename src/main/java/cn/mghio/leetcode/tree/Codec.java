package cn.mghio.leetcode.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Serialize and Deserialize Binary Tree.
 *
 * @author mghio
 * @since 2021-12-28
 */
public class Codec {

  /**
   * the Delimiter
   */
  private static final String SEP = ",";

  /**
   * represent the null
   */
  private static final String NULL = "#";

  /**
   * Serialize binary tree
   *
   * @param root the root node
   * @return the serialized data
   */
  public String doSerialize(TreeNode root) {
    return doSerialize(root, new StringBuilder()).toString();
  }

  /**
   * Deserialize binary tree
   *
   * @param data the serialized data
   * @return the deserialized binary tree
   */
  public TreeNode deserialize(String data) {
    List<String> nodes = new LinkedList<>(Arrays.asList(data.split(SEP)));
    return doDeserialize(nodes);
  }

  private TreeNode doDeserialize(List<String> nodes) {
    if (nodes.isEmpty()) {
      return null;
    }

    String rootVal = nodes.get(0);
    if (rootVal.equals(NULL)) {
      nodes.remove(0);
      return null;
    }

    TreeNode root = new TreeNode(Integer.parseInt(rootVal));
    nodes.remove(0);
    root.left = doDeserialize(nodes);
    root.right = doDeserialize(nodes);
    return root;
  }

  private StringBuilder doSerialize(TreeNode root, StringBuilder sb) {
    if (root == null) {
      sb.append(NULL).append(SEP);
      return sb;
    }

    sb.append(root.val).append(SEP);
    doSerialize(root.left, sb);
    doSerialize(root.right, sb);
    return sb;
  }

}
