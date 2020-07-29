package array;

public class MinSizeSubarraySum {
    /*
    LeetCode – Minimum Size Subarray Sum (Java)
    Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which the sum ≥ s.
    If there isn't one, return 0 instead.

    For example, given the array [2,3,1,2,4,3] and s = 7, the subarray [4,3] has the minimal length of 2 under the problem constraint.
     */
    public int minSubArrayLen(int s, int[] nums) {
        int result = nums.length;
        int i = 0;
        int j = 0;
        int sum = 0;
        while (i < nums.length) {
            if (sum < s) {
                sum += nums[i++];
            } else {
                result = Math.min(result, i-j);
                sum -= nums[j++];
            }
        }

        while (sum >= s) {
            result = Math.min(result, i-j);
            sum -= nums[j++];
        }

        return result;
    }
}
