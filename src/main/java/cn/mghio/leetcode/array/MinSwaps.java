package cn.mghio.leetcode.array;

/**
 * A swap is defined as taking two distinct positions in an array and swapping the values in them.
 *
 * A circular array is defined as an array where we consider the first element and the last element
 * to be adjacent.
 *
 * Given a binary circular array nums, return the minimum number of swaps required to group all 1's
 * present in the array together at any location.
 *
 * @author mghio
 * @since 2022-03-14
 */
public class MinSwaps {

  public int minSwaps(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    int oneCount = 0;
    for (int num : nums) {
      if (num == 1) {
        oneCount++;
      }
    }

    int len = nums.length;
    int[] rets = new int[len];
    for (int i = 0; i < len; i++) {
      int step = 0;
      int zeroCount = 0;
      for (int j = i; step < oneCount; j++) {
        if (j >= len) {
          j = 0;
        }
        if (nums[j] == 0) {
          zeroCount++;
        }
        step++;
      }
      rets[i] = zeroCount;
    }

    int res = Integer.MAX_VALUE;
    for (int i : rets) {
      res = Math.min(res, i);
    }

    return res;
  }

  /**
   * Count the number of 1s in the sliding window, and then subtract the total number
   *
   * @param nums the nums array
   * @return the minimum number of swaps
   */
  public int minSwapsSolution2(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    // the total number of 1 in the array
    int cnt = 0;
    // 1 number in the sliding window now
    int num = 0;
    int len = nums.length;

    for (int j : nums) {
      cnt += j;
    }

    for (int i = 0; i < cnt; i++) {
      num += nums[i];
    }

    // the maximum number of 1 in the sliding window
    int ans = num;
    for (int i = 0; i < len - 1; i++) {
      num += nums[(cnt + i) % len] - nums[i];
      ans = Math.max(ans, num);
    }
    return cnt - ans;
  }

  /**
   * sliding window
   *
   * @param nums the nums array
   * @return the minimum number of swaps
   */
  public int minSwapsSolution3(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    int len = nums.length;
    int ans = Integer.MAX_VALUE;
    int oneCount = 0;

    for (int num : nums) {
      oneCount += num;
    }

    for (int i = 0, zeroCount = 0; i < 2 * len; i++) {
      if (i >= oneCount) {
        ans = Math.min(ans, zeroCount);
        if (nums[(i - oneCount) % len] == 0) {
          zeroCount--;
        }
      }

      if (nums[i % len] == 0) {
        zeroCount++;
      }
    }

    return ans;
  }

}
