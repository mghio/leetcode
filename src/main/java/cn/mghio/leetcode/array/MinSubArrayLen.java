package cn.mghio.leetcode.array;

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 target。 找出该数组中满足其和 ≥ target
 * 的长度最小的连续子数组[numsl, numsl+1, ..., numsr-1, numsr]， 并返回其长度。
 * 如果不存在符合条件的子数组，返回 0。
 *
 * 进阶：如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(nlog(n)) 时间复杂度的解法。
 *
 * 提示：
 * 1 <= target <= 109
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 105
 *
 * @author mghio
 * @since 2021-04-10
 */
public class MinSubArrayLen {

  public int minSubArrayLen(int target, int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    // 方法一：暴力解法
//    int result = violentSolution(target, nums);

    // 方法二：二分查找法 + 前缀和
//    int result = binarySearchWithPrefixSum(target, nums);

    // 方法三：双指针法（滑动窗口）
    int result = doublePoint(target, nums);

    return result;
  }

  private int doublePoint(int target, int[] nums) {
    int result = Integer.MAX_VALUE;
    int slow = 0;
    int fast = 0;
    int sum = 0;
    int n = nums.length;
    while (fast < n) {
      sum += nums[fast];
      while (sum >= target) {
        result = Math.min(result, fast - slow + 1);
        sum -= nums[slow];
        slow++;
      }
      fast++;
    }

    return result == Integer.MAX_VALUE ? 0 : result;
  }

  /**
   * 方法二：前缀和 + 二分查找
   * 时间复杂度：O(nlogn)，空间复杂度：O(n)
   */
  private int binarySearchWithPrefixSum(int s, int[] nums) {
    int n = nums.length;
    int ans = Integer.MAX_VALUE;
    int[] sums = new int[n + 1];
    // 为了方便计算，令 size = n + 1
    // sums[0] = 0 意味着前 0 个元素的前缀和为 0
    // sums[1] = A[0] 前 1 个元素的前缀和为 A[0]
    // 以此类推
    for (int i = 1; i <= n; i++) {
      sums[i] = sums[i - 1] + nums[i - 1];
    }
    for (int i = 1; i <= n; i++) {
      int target = s + sums[i - 1];
      int bound = binarySearch(sums, target);
      if (bound < 0) {
        bound = -bound - 1;
      }
      if (bound <= n) {
        ans = Math.min(ans, bound - (i - 1));
      }
    }
    return ans == Integer.MAX_VALUE ? 0 : ans;
  }

  /**
   * 方法一：暴力解法
   * 时间复杂度：O(n^2)，空间复杂度：O(1)
   */
  private int violentSolution(int target, int[] nums) {
    int n = nums.length;
    int result = Integer.MAX_VALUE;
    for (int i = 0; i < n; i++) {
      int sum = 0;
      for (int j = i; j < n; j++) {
        sum += nums[j];
        if (sum >= target) {
          result = Math.min(result, j - i + 1);
          break;
        }
      }
    }

    return result == Integer.MAX_VALUE ? 0 : result;
  }

  private int binarySearch(int[] nums, int target) {
    int low = 0, mid, high = nums.length - 1;
    while (low <= high) {
      mid = (high + low) >>> 1;
      int midVal = nums[mid];
      if (midVal == target) {
        return mid;
      } else if (midVal < target) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return -(low + 1);
  }

}
