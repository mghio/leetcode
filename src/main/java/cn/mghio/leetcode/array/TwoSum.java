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
      return new int[]{-1, -1};
    }

    // 方法一：暴力求解，没有用到有序数组的条件
//    int[] result = violentSolution(nums, target);

    // 方法二：二分查找法
//    int[] result = binarySearch(nums, target);

    // 方法三：双指针法
    int[] result = doublePoint(nums, target);

    return result;
  }

  private int[] doublePoint(int[] nums, int target) {
    int low = 0, high = nums.length - 1;
    while (low < high) {
      int sum = nums[low] + nums[high];
      if (sum == target) {
        return new int[]{low + 1, high + 1};
      } else if (sum > target) {
        high--;
      } else {
        low++;
      }
    }
    return new int[]{-1, -1};
  }

  /**
   * 方法二：二分查找法，充分利用了数组有序的特点
   */
  private int[] binarySearch(int[] nums, int target) {
    for (int i = 0; i < nums.length; i++) {
      int low = i + 1, high = nums.length - 1;
      while (low <= high) {
        int mid = (high - low) / 2 + low;
        int subtractResult = target - nums[i];
        if (nums[mid] == subtractResult) {
          return new int[]{i + 1, mid + 1};
        } else if (nums[mid] > subtractResult) {
          high = mid - 1;
        } else {
          low = mid + 1;
        }
      }
    }

    return new int[]{-1, -1};
  }

  /**
   * 方法一：暴力求解
   */
  private int[] violentSolution(int[] nums, int target) {
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

    return new int[]{-1, -1};
  }

}
