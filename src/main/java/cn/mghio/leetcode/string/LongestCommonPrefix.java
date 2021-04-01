package cn.mghio.leetcode.string;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。如果不存在公共前缀，返回空字符串 ""。
 *
 * @author mghio
 * @since 2021-03-31
 */
public class LongestCommonPrefix {

  public String longestCommonPrefix(String[] strs) {
    if (strs == null || strs.length < 2) {
      return "";
    }

    // 方法一：横向扫描法
//    String commonPrefix = horizontalScan(strs);

    // 方法二：纵向扫描法
    String commonPrefix = verticalScan(strs);

    return commonPrefix;
  }

  /**
   * 方法二：纵向扫描法
   */
  private String verticalScan(String[] strs) {
    int length = strs[0].length();
    int count = strs.length;

    for (int i = 0; i < length; i++) {
      char c = strs[0].charAt(i);
      for (int j = 1; j < count; j++) {
        if (i == strs[j].length() || strs[j].charAt(i) != c) {
          return strs[0].substring(0, i);
        }
      }
    }
    return strs[0];
  }

  /**
   * 方法一：横向扫描法
   */
  private String horizontalScan(String[] strs) {
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
