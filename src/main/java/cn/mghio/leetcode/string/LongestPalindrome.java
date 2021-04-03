package cn.mghio.leetcode.string;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 * @author mghio
 * @since 2021-04-02
 */
public class LongestPalindrome {

  public String longestPalindrome(String s) {
    if (s == null || s.length() < 2) {
      return s;
    }

    // 方法一：暴力解法
//    String result = violentSolution(s);

    // 方法二：中心扩散法
//    String result = expandCenter(s);

    // 方法三：动态规划法
    String result = dynamicProgramming(s);

    return result;
  }

  /**
   * 方法三：动态规划法
   */
  private String dynamicProgramming(String s) {
    int maxLen = 1;
    int begin = 0;
    int len = s.length();

    // dp[i][j] 表示 s[i ... j] 是否是回文
    boolean[][] dp = new boolean[len][len];
    for (int i = 0; i < len; i++) {
      dp[i][i] = true;
    }

    char[] charArray = s.toCharArray();
    // 注意：左下角先填
    for (int i = 1; i < len; i++) {
      for (int j = 0; j < i; j++) {
        if (charArray[j] != charArray[i]) {
          dp[j][i] = false;
        } else {
          if (i - j < 3) {
            dp[j][i] = true;
          } else {
            dp[j][i] = dp[j + 1][i - 1];
          }
        }
        // 只要 dp[j][i] = true 成功，就表示子串 s[i ... j] 是回文，则记录回文的长度和起始位置
        if (dp[j][i] && i - j + 1 > maxLen) {
          maxLen = i - j + 1;
          begin = j;
        }
      }
    }

    String result = s.substring(begin, begin + maxLen);
    return result;
  }

  /**
   * 方法二：中心扩散法
   */
  private String expandCenter(String s) {
    int maxLen = 1;
    int begin = 0;
    char[] charArray = s.toCharArray();
    for (int i = 0, len = s.length(); i < len - 1; i++) {
      int oddLen = expandAroundCenter(charArray, i, i);
      int evenLen = expandAroundCenter(charArray, i, i + 1);

      int curMaxLen = Math.max(oddLen, evenLen);
      if (curMaxLen > maxLen) {
        maxLen = curMaxLen;
        // 这一步需要在纸上画图发现规律
        begin = i - (maxLen - 1) / 2;
      }
    }

    return s.substring(begin, begin + maxLen);
  }

  /**
   * @param charArray 原始字符串的字符数组
   * @param left      起始左边界（可以取到）
   * @param right     起始右边界（可以取到）
   * @return 回文串的长度
   */
  private int expandAroundCenter(char[] charArray, int left, int right) {
    // 当 left = right 的时候，回文串的中心是一个字符，回文串的长度是一个奇数
    // 当 left = right + 1 的时候，此时回文串的中心是两个字符，回文串的长度是偶数
    int len = charArray.length;
    int i = left;
    int j = right;

    while (i >= 0 && j < len) {
      if (charArray[i] == charArray[j]) {
        i--;
        j++;
      } else {
        break;
      }
    }

    // 跳出 while 循环时，恰好满足 s.chatAt(i) != s.chatAt(j)
    // 回文串的长度是 j - i + 1 - 2 = j - i - 1
    return j - i - 1;
  }

  /**
   * 方法一：暴力解法
   */
  private String violentSolution(String s) {
    int maxLen = 1;
    int begin = 0;
    // s.chatAt(i) 每次都会检查数组下标越界，因此先转换成字符数组，这一步非必须
    char[] charArray = s.toCharArray();

    // 枚举所有长度大于 1 的子串
    for (int i = 0, len = s.length(); i < len - 1; i++) {
      for (int j = i + 1; j < len; j++) {
        int curMaxLen = j - i + 1;
        if (curMaxLen > maxLen && validPalindrome(charArray, i, j)) {
          maxLen = curMaxLen;
          begin = i;
        }
      }
    }

    return s.substring(begin, begin + maxLen);
  }

  /**
   * 验证子串是否为回文串
   */
  private boolean validPalindrome(char[] charArray, int left, int right) {
    while (left < right) {
      if (charArray[left++] != charArray[right--]) {
        return false;
      }
    }
    return true;
  }

}
