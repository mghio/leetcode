package java.cn.mghio.leetcode.string;

/**
 * Trie Node.
 *
 * @author mghio
 * @since 2021-10-08
 */
public class TrieNode {

  public static final Integer TRIE_TREE_CHILDREN_NUM = 26;

  public char data;
  public TrieNode[] children = new TrieNode[TRIE_TREE_CHILDREN_NUM];
  public boolean isEndingChar = false;

  public TrieNode(char data) {
    this.data = data;
  }
}
