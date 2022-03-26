package cn.mghio.leetcode.string;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Letter Combinations of a Phone Number.
 *
 * @author mghio
 * @since 2022-03-26
 */
public class LetterCombinations {

  private static final ConcurrentMap<Character, String[]> MAP = new ConcurrentHashMap<>() {{
    put('2', new String[]{"a", "b", "c"});
    put('3', new String[]{"d", "e", "f"});
    put('4', new String[]{"g", "h", "i"});
    put('5', new String[]{"j", "k", "l"});
    put('6', new String[]{"m", "n", "o"});
    put('7', new String[]{"p", "q", "r", "s"});
    put('8', new String[]{"t", "u", "v"});
    put('9', new String[]{"w", "x", "y", "z"});
  }};

  public List<String> letterCombinations(String digits) {
    List<String> combinations = new ArrayList<>();
    if (digits == null || digits.length() == 0) {
      return combinations;
    }

    backtrack(combinations, digits, 0, new StringBuilder());
    return combinations;
  }

  private void backtrack(List<String> combinations, String digits, int index, StringBuilder sb) {
    if (index == digits.length()) {
      combinations.add(sb.toString());
      return;
    }

    char digit = digits.charAt(index);
    String[] letters = MAP.get(digit);
    for (String letter : letters) {
      sb.append(letter);
      backtrack(combinations, digits, index + 1, sb);
      sb.deleteCharAt(index);
    }
  }

  /*-------------------------------------- solution 2----------------------------------------*/

  private static final ConcurrentMap<Character, String> MAP2 = new ConcurrentHashMap<>() {{
    put('2',"abc");
    put('3', "def");
    put('4', "ghi");
    put('5', "jkl");
    put('6', "mno");
    put('7', "pqrs");
    put('8', "tuv");
    put('9', "wxyz");
  }};

  public List<String> letterCombinations2(String digits) {
    List<String> combinations = new ArrayList<>();
    if (digits == null || digits.length() == 0) {
      return combinations;
    }

    backtrack2(combinations, digits, 0, new StringBuilder());
    return combinations;
  }

  private void backtrack2(List<String> combinations, String digits, int index, StringBuilder sb) {
    if (index == digits.length()) {
      combinations.add(sb.toString());
      return;
    }

    char digit = digits.charAt(index);
    String letters = MAP2.get(digit);
    for (int i = 0, len = letters.length(); i < len; i++) {
      sb.append(letters.charAt(i));
      backtrack2(combinations, digits, index + 1, sb);
      sb.deleteCharAt(index);
    }
  }

}
