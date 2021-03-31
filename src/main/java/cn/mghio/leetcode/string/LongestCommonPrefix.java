package cn.mghio.leetcode.string;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。如果不存在公共前缀，返回空字符串 ""。
 *
 * @author mghio
 * @since 2021-03-31
 */
public class LongestCommonPrefix {

  /**
   * 方法一：横向扫描法
   */
  public String longestCommonPrefix(String[] strs) {
    if (strs == null || strs.length < 2) {
      return "";
    }

    String commonPrefix = strs[0];
    int count = strs.length;
    for (int i = 1; i < count; i++) {
      int length = Math.min(commonPrefix.length(), strs[i].length());
      int index = 0;
      while (index < length && commonPrefix.charAt(index) == strs[i].charAt(index)) {
        index++;
      }
      commonPrefix = commonPrefix.substring(0, index);
      if (commonPrefix.length() == 0) {
        break;
      }
    }

    return commonPrefix;
  }

}
