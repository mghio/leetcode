package cn.mghio.leetcode.array;

/**
 * Given an integer array nums and an integer k, return true if it is possible to divide this array
 * into k non-empty subsets whose sums are all equal.
 *
 * @author mghio
 * @since 2022-02-12
 */
public class CanPartitionKSubsets {

  /**
   * Return true if it is possible to divide this array into non-empty subsets whose sums are all
   * equal
   */
  public boolean canPartitionKSubsets(int[] nums, int k) {
    if (nums == null || nums.length == 0) {
      return false;
    }

    if (nums.length < k) {
      return false;
    }

    int sum = 0;
    for (int num : nums) {
      sum += num;
    }
    if (sum % k != 0) {
      return false;
    }

    int[] bucket = new int[k];
    int targetSum = sum / k;
    return backtrack(nums, 0, bucket, targetSum);
  }

  private boolean backtrack(int[] nums, int index, int[] buckets, int sum) {
    if (nums.length == index) {
      for (int bucket : buckets) {
        if (bucket != sum) {
          return false;
        }
      }
      return true;
    }

    for (int i = 0; i < buckets.length; i++) {
      if (buckets[i] + nums[index] > sum) {
        continue;
      }

      buckets[i] += nums[index];
      if (backtrack(nums, index + 1, buckets, sum)) {
        return true;
      }
      buckets[i] -= nums[index];
    }

    return false;
  }

  /**
   * Return true if it is possible to divide this array into non-empty subsets whose sums are all
   * equal
   */
  public boolean canPartitionKSubsetsSolution2(int[] nums, int k) {
    if (nums == null || nums.length == 0) {
      return false;
    }
    if (nums.length < k) {
      return false;
    }
    int sum = 0;
    for (int num : nums) {
      sum += num;
    }
    if (sum % k != 0) {
      return false;
    }

    int targetSum = sum / k;
    boolean[] used = new boolean[nums.length];
    return backtrack(k, 0, nums, 0, used, targetSum);
  }

  private boolean backtrack(int k, int bucket, int[] nums, int start, boolean[] used, int target) {
    if (k == 0) {
      return true;
    }

    if (bucket == target) {
      return backtrack(k - 1, 0, nums, 0, used, target);
    }

    for (int i = start; i < nums.length; i++) {
      if (used[i]) {
        continue;
      }
      if (bucket + nums[i] > target) {
        continue;
      }

      used[i] = true;
      bucket += nums[i];
      if (backtrack(k, bucket, nums, i + 1, used, target)) {
        return true;
      }
      used[i] = false;
      bucket -= nums[i];
    }

    return false;
  }

}
