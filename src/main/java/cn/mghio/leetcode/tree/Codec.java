package cn.mghio.leetcode.tree;

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

  //-------------------------------------- pre order --------------------------------------

  /**
   * Serialize binary tree
   *
   * @param root the root node
   * @return the serialized data
   */
  public String serializeUsePreOrderTraversal(TreeNode root) {
    StringBuilder sb = new StringBuilder();
    return serializeUsePreOrderTraversal(root, sb).toString();
  }

  /**
   * Deserialize binary tree
   *
   * @param data the serialized data
   * @return the deserialized binary tree
   */
  public TreeNode deserializeUsePreOrderTraversal(String data) {
    if (data == null || data.length() == 0) {
      return null;
    }

    List<String> list = new LinkedList<>();
    String[] nodes = data.split(SEP);
    for (String node : nodes) {
      list.add(node);
    }
    return deserializeUsePreOrderTraversal(list);
  }

  private TreeNode deserializeUsePreOrderTraversal(List<String> nodes) {
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
    root.left = deserializeUsePreOrderTraversal(nodes);
    root.right = deserializeUsePreOrderTraversal(nodes);
    return root;
  }

  private StringBuilder serializeUsePreOrderTraversal(TreeNode root, StringBuilder sb) {
    if (root == null) {
      sb.append(NULL).append(SEP);
      return sb;
    }

    sb.append(root.val).append(SEP);
    serializeUsePreOrderTraversal(root.left, sb);
    serializeUsePreOrderTraversal(root.right, sb);
    return sb;
  }

  //-------------------------------------- post order --------------------------------------

  public String serializeUsePostOrderTraversal(TreeNode root) {
    if (root == null) {
      return null;
    }

    StringBuilder sb = new StringBuilder();
    serializeUsePostOrderTraversal(root, sb);
    return sb.toString();
  }

  public TreeNode deserializePostOrderTraversal(String data) {
    if (data == null || data.length() == 0) {
      return null;
    }

    LinkedList<String> list = new LinkedList<>();
    String[] nodes = data.split(SEP);
    for (String node : nodes) {
      list.add(node);
    }
    return deserializePostOrderTraversal(list);
  }

  private TreeNode deserializePostOrderTraversal(LinkedList<String> list) {
    if (list == null || list.isEmpty()) {
      return null;
    }

    String last = list.removeLast();
    if (NULL.equals(last)) {
      return null;
    }
    TreeNode root = new TreeNode(Integer.parseInt(last));

    root.right = deserializePostOrderTraversal(list);
    root.left = deserializePostOrderTraversal(list);
    return root;
  }

  private void serializeUsePostOrderTraversal(TreeNode root, StringBuilder sb) {
    if (root == null) {
      sb.append(NULL).append(SEP);
      return;
    }

    serializeUsePostOrderTraversal(root.left, sb);
    serializeUsePostOrderTraversal(root.right, sb);
    sb.append(root.val).append(SEP);
  }

}
