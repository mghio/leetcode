package java.cn.mghio.leetcode.thinking;

/**
 * Do not use the new variable, swap the values of the two variables.
 *
 * @author mghio
 * @since 2021-10-16
 */
public class Swap {

  /**
   * swap the values of the two variables use arithmetic.
   *
   * @param numbers the numbers array
   * @return the swapped numbers array
   */
  public int[] swapNumbersUseArithmetic(int[] numbers) {
    if (numbers == null || numbers.length < 2) {
      return numbers;
    }

    numbers[0] = numbers[0] + numbers[1];
    numbers[1] = numbers[0] - numbers[1];
    numbers[0] = numbers[0] - numbers[1];
    return numbers;
  }

  /**
   * swap the values of the two variables use XOR.
   *
   * @param numbers the numbers array
   * @return the swapped numbers array
   */
  public int[] swapNumbersUseXOR(int[] numbers) {
    if (numbers == null || numbers.length < 2) {
      return numbers;
    }

    numbers[0] = numbers[0] ^ numbers[1];
    // numbers[0] ^ numbers[1] = numbers[0] ^ numbers[1] ^ numbers[1] = numbers[0]
    numbers[1] = numbers[0] ^ numbers[1];
    // numbers[0] ^ numbers[1] = numbers[0] ^ numbers[1] ^ numbers[0] = numbers[1]
    numbers[0] = numbers[0] ^ numbers[1];
    return numbers;
  }

}
