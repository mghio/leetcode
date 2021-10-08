package java.cn.mghio.leetcode.string;

/**
 * Trie Tree.
 *
 * @author mghio
 * @since 2021-10-08
 */
public class Trie {

  /**
   * The trie tree root node(virtual node).
   */
  private final TrieNode root = new TrieNode('/');

  /**
   * Insert a char array into a trie tree.
   *
   * @param text the char array
   */
  public void insert(char[] text) {
    TrieNode p = root;

    for (char curChar : text) {
      int index = curChar - 'a';
      if (p.children[index] == null) {
        p.children[index] = new TrieNode(curChar);
      }
      p = p.children[index];
    }

    p.isEndingChar = true;
  }

  /**
   * determine is exists in the string.
   *
   * @param pattern the pattern string
   * @return true - exists, Else false
   */
  public boolean find(char[] pattern) {
    TrieNode p = root;

    for (char curChar : pattern) {
      int index = curChar - 'a';
      if (p.children[index] == null) {
        return false;
      }
      p = p.children[index];
    }

    return p.isEndingChar;
  }

}
