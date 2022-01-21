package cn.mghio.leetcode.array;

/**
 * There are n flights that are labeled from 1 to n.
 *
 * You are given an array of flight bookings bookings, where bookings[i] = [firsti, lasti, seatsi]
 * represents a booking for flights firsti through lasti (inclusive) with seatsi seats reserved for
 * each flight in the range.
 *
 * Return an array answer of length n, where answer[i] is the total number of seats reserved for
 * flight i.
 *
 * @author mghio
 * @since 2022-01-21
 */
public class CorpFlightBookings {

  /**
   * Return an array answer of length n, where answer[i] is the total number of seats reserved for
   * flight i.
   *
   * @param bookings the booking array
   * @param n the max flight number
   * @return the total number of seats reserved for flight i
   */
  public int[] corpFlightBookings(int[][] bookings, int n) {
    int[] nums = new int[n];
    DiffArray diff = new DiffArray(nums);

    for (int[] booking : bookings) {
      int i = booking[0] - 1;
      int j = booking[1] - 1;
      int val = booking[2];
      diff.increment(i, j, val);
    }

    return diff.result();
  }

  static class DiffArray {

    private final int[] diff;

    public DiffArray(int[] nums) {
      assert nums.length > 0;
      diff = new int[nums.length];
      diff[0] = 0;
      for (int i = 1; i < nums.length; i++) {
        diff[i] = nums[i] - nums[i - 1];
      }
    }

    /**
     * add val (can be negative) to the closed interval [i,j]
     *
     * @param startIndex the start index
     * @param endIndex the end index
     * @param val the value
     */
    public void increment(int startIndex, int endIndex, int val) {
      diff[startIndex] += val;
      if (endIndex + 1 < diff.length) {
        diff[endIndex + 1] -= val;
      }
    }

    public int[] result() {
      int[] res = new int[diff.length];
      res[0] = diff[0];
      for (int i = 1; i < diff.length; i++) {
        res[i] = res[i - 1] + diff[i];
      }
      return res;
    }

  }

}
