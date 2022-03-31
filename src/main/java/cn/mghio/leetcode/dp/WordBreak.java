package cn.mghio.leetcode.dp;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Word Break.
 *
 * @author mghio
 * @since 2022-03-31
 */
public class WordBreak {

  public boolean wordBreak(String s, List<String> wordDict) {
    if (s == null || s.length() == 0) {
      return true;
    }

    int len = s.length();
    Set<String> wordDictSet = new HashSet<>(wordDict);
    // dp[i] 表示字符串 s 前 i 个字符组成的字符串 s[0 ... i - 1] 是否能被空格拆分成若干个字典出现的单词
    boolean[] dp = new boolean[len + 1];
    dp[0] = true;
    for (int i = 1; i <= len; i++) {
      for (int j = 0; j < i; j++) {
        if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
          dp[i] = true;
          break;
        }
      }
    }
    return dp[len];
  }

}
