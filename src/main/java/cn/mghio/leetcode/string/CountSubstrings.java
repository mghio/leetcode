package cn.mghio.leetcode.string;

/**
 * Palindromic Substrings.
 *
 * @author mghio
 * @since 2022-04-03
 */
public class CountSubstrings {

  public int countSubstrings(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }

    int len = s.length();
    int ret = 0;
    for (int i = 0; i < 2 * len - 1; i++) {
      int l = i / 2;
      int r = i / 2 + i % 2;
      while (l >= 0 && r < len && s.charAt(l) == s.charAt(r)) {
        l--;
        r++;
        ret++;
      }
    }
    return ret;
  }

}
