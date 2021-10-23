package java.cn.mghio.leetcode.array;

import java.util.Arrays;

/**
 * In the two numbers in the array, if the first number is greater than the following number, the
 * two numbers form a reverse pair. Enter an array and find the total number of reverse pairs in
 * this array.
 *
 * @author mghio
 * @since 2021-10-22
 */
public class ReversePairs {

  /**
   * Given an array and find the total number of reverse pairs in this array.
   *
   * NOTE: time out.
   *
   * @param nums the array
   * @return the total number of reverse pairs
   */
  public int reversePairsSolution1(int[] nums) {
    if (nums == null) {
      return 0;
    }

    int number = 0;
    int len = nums.length;
    for (int i = 0; i < len; i++) {
      for (int j = i + 1; j < len; j++) {
        if (nums[i] > nums[j]) {
          number++;
        }
      }
    }
    return number;
  }

  /**
   * Given an array and find the total number of reverse pairs in this array.
   *
   * @param nums the array
   * @return the total number of reverse pairs
   */
  public int reversePairsSolution2(int[] nums) {
    if (nums == null) {
      return 0;
    }

    int len = nums.length;
    if (len < 2) {
      return 0;
    }

    int[] copy = new int[len];
    System.arraycopy(nums, 0, copy, 0, len);

    int[] tmp = new int[len];
    return reversePair(copy, 0, len - 1, tmp);
  }

  /**
   * Given an array and find the total number of reverse pairs in this array.
   *
   * @param nums the array
   * @return the total number of reverse pairs
   */
  public int reversePairsSolution3(int[] nums) {
    if (nums == null) {
      return 0;
    }

    int len = nums.length;
    int[] tmp = new int[len];
    System.arraycopy(nums, 0, tmp, 0, len);
    Arrays.sort(tmp);

    for (int i = 0; i < len; i++) {
      nums[i] = Arrays.binarySearch(tmp, nums[i]) + 1;
    }

    BIT bit = new BIT(len);
    int ans = 0;
    for (int i = len - 1; i >= 0; i--) {
      ans += bit.query(nums[i] - 1);
      bit.update(nums[i]);
    }
    return ans;
  }

  private int reversePair(int[] nums, int left, int right, int[] tmp) {
    if (left == right) {
      return 0;
    }

    int mid = left + ((right - left) >> 2);
    int leftPairs = reversePair(nums, left, mid, tmp);
    int rightPairs = reversePair(nums, mid + 1, right, tmp);
    if (nums[mid] <= nums[mid + 1]) {
      return leftPairs + rightPairs;
    }

    int crossPairs = mergeAndCount(nums, left, mid, right, tmp);
    return leftPairs + rightPairs + crossPairs;
  }

  private int mergeAndCount(int[] nums, int left, int mid, int right, int[] tmp) {
    // left ... right: tmp[i] = nums[i]
    if (right + 1 - left >= 0) {
      System.arraycopy(nums, left, tmp, left, right + 1 - left);
    }

    int i = left;
    int j = mid + 1;
    int count = 0;
    for (int k = left; k <= right; k++) {
      if (i == mid + 1) {
        nums[k] = tmp[j];
        j++;
      } else if (j == right + 1) {
        nums[k] = tmp[i];
        i++;
      } else if (tmp[i] <= tmp[j]) {
        nums[k] = tmp[i];
        i++;
      } else {
        nums[k] = tmp[j];
        j++;
        count += (mid - i + 1);
      }
    }
    return count;
  }

  public static class BIT {
    private final int[] tree;
    private final int n;

    public BIT(int n) {
      this.n = n;
      this.tree = new int[n + 1];
    }

    public static int lowBit(int x) {
      return x & (-x);
    }

    public int query(int x) {
      int ret = 0;
      while (x != 0) {
        ret += tree[x];
        x -= lowBit(x);
      }
      return ret;
    }

    public void update(int x) {
      while (x < n) {
        ++tree[x];
        x += lowBit(x);
      }
    }
  }

}
