package cn.mghio.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个已按照 升序排列 的整数数组 numbers ，请你从数组中找出两个数满足相加之和等于目标数 target。 函数应该以长度为 2 的整数数组的形式返回这两个数的下标值。numbers
 * 的下标 从 1 开始计数 ， 所以答案数组应当满足 1 <= answer[0] < answer[1] <= numbers.length 。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 *
 * @author mghio
 * @since 2021-04-08
 */
public class TwoSum {

  public int[] twoSum(int[] nums, int target) {
    if (nums == null || nums.length < 2) {
      return new int[]{0, 0};
    }

    int len = nums.length;
    Map<Integer, Integer> map = new HashMap<>(len);
    int[] resultArr = new int[2];
    for (int i = 0; i < len; i++) {
      map.put(nums[i], i + 1);
    }

    for (int i = 0; i < len; i++) {
      int result = target - nums[i];
      if (map.containsKey(result)) {
        resultArr[0] = Math.min(i + 1, map.get(result));
        resultArr[1] = Math.max(i + 1, map.get(result));
        return resultArr;
      }
    }

    return new int[]{0, 0};
  }

}
