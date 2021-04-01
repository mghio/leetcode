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
//    String commonPrefix = verticalScan(strs);

    // 方法三：分治法
    String commonPrefix = divideAndConquer(strs);

    return commonPrefix;
  }

  /**
   * 方法三：分治法
   */
  private String divideAndConquer(String[] strs) {
    return longestCommonPrefix(strs, 0, strs.length - 1);
  }

  private String longestCommonPrefix(String[] strs, int start, int end) {
    if (start == end) {
      return strs[start];
    }
    int mid = (end - start) / 2 + start;
    String lcpLeft = longestCommonPrefix(strs, start, mid);
    String lcpRight = longestCommonPrefix(strs, mid + 1, end);
    return commonPrefix(lcpLeft, lcpRight);
  }

  private String commonPrefix(String lcpLeft, String lcpRight) {
    int minLength = Math.min(lcpLeft.length(), lcpRight.length());
    for (int i = 0; i < minLength; i++) {
      if (lcpLeft.charAt(i) != lcpRight.charAt(i)) {
        return lcpLeft.substring(0, i);
      }
    }
    return lcpLeft.substring(0, minLength);
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
