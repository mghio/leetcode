package cn.mghio.leetcode.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how
 * your serialization/deserialization algorithm should work. You just need to ensure that a binary
 * tree can be serialized to a string and this string can be deserialized to the original tree
 * structure.
 *
 * @author mghio
 * @since 2021-09-28
 */
public class BinaryTreeCodec {

  private static final String DELIMITER = ",";
  private static final String NULL_PLACEHOLDER = "NULL";

  /**
   * Encode a binary tree to single string.
   *
   * @param root the root node
   * @return the single string represent binary tree
   */
  public String serialize(TreeNode root) {
    return serialize(root, new StringBuilder()).toString();
  }

  private StringBuilder serialize(TreeNode node, StringBuilder dataBuilder) {
    if (node == null) {
      dataBuilder.append(NULL_PLACEHOLDER + DELIMITER);
    } else {
      dataBuilder.append(node.val).append(DELIMITER);
      dataBuilder = serialize(node.left, dataBuilder);
      dataBuilder = serialize(node.right, dataBuilder);
    }
    return dataBuilder;
  }

  /**
   * Decode a single string to binary tree.
   *
   * @param data the encoded data
   * @return the root node
   */
  public TreeNode deserialize(String data) {
    List<String> dataList = new LinkedList<>(List.of(data.split(DELIMITER)));
    return deserialize(dataList);
  }

  private TreeNode deserialize(List<String> dataList) {
    // the root node is null
    if (NULL_PLACEHOLDER.equals(dataList.get(0))) {
      dataList.remove(0);
      return null;
    }

    TreeNode root = new TreeNode(Integer.parseInt(dataList.get(0)));
    dataList.remove(0);
    root.left = deserialize(dataList);
    root.right = deserialize(dataList);

    return root;
  }

}
