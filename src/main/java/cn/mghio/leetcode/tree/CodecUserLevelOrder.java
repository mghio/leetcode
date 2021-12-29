package cn.mghio.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Serialize and Deserialize binary tree use level order.
 *
 * @author mghio
 * @since 2021-12-29
 */
public class CodecUserLevelOrder {

  private static final String SEP = ",";
  private static final String NULL = "#";

  public String serialize(TreeNode root) {
    if (root == null) {
      return "";
    }

    StringBuilder sb = new StringBuilder();
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      TreeNode node = queue.poll();

      if (node == null) {
        sb.append(NULL).append(SEP);
        continue;
      }
      sb.append(node.val).append(SEP);

      queue.offer(node.left);
      queue.offer(node.right);
    }

    return sb.toString();
  }

  public TreeNode deserialize(String data) {
    if (data == null || data.isEmpty()) {
      return null;
    }

    String[] nodes = data.split(SEP);
    TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    for (int i = 1; i < nodes.length; i++) {
      TreeNode parent = queue.poll();

      String left = nodes[i++];
      assert parent != null;
      if (!left.equals(NULL)) {
        parent.left = new TreeNode(Integer.parseInt(left));
        queue.offer(parent.left);
      } else {
        parent.left = null;
      }

      String right = nodes[i++];
      if (!right.equals(NULL)) {
        parent.right = new TreeNode(Integer.parseInt(right));
        queue.offer(parent.right);
      } else {
        parent.right = null;
      }
    }
    return root;
  }

}
