package java.cn.mghio.leetcode.dp;

/**
 * Given a number, we translate it into a string according to the following rules: 0 is translated
 * into "a", 1 is translated into "b", ..., 11 is translated into "l", ..., 25 is translated into
 * "z". There may be multiple translations for a number. Please program a function to calculate how
 * many different translation methods a number has.
 *
 * @author mghio
 * @since 2021-11-04
 */
public class TranslateNum {

  /**
   * Translate num.
   *
   * @param num the num
   * @return the translate result
   */
  public int translateNum(int num) {
    String src = String.valueOf(num);

    int p = 0;
    int q = 0;
    int r = 1;
    for (int i = 0; i < src.length(); i++) {
      p = q;
      q = r;
      r = 0;
      r = r + q;
      if (i == 0) {
        continue;
      }

      String pre = src.substring(i - 1, i + 1);
      if (pre.compareTo("10") >= 0 && pre.compareTo("25") <= 0) {
        r += p;
      }
    }

    return r;
  }

}
