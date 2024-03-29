package old.simplepointers;

public class ProductOfArrayExceptSelf {
    /*
    LeetCode – Product of Array Except Self (Java)
    Given an array of n integers where n > 1, nums,
    return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

    Solve it without division and in O(n).
    For example, given [1,2,3,4], return [24,12,8,6].
     */
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        int[] left = new int[nums.length];
        int[] right = new int[nums.length];

        left[0] = 1;
        for(int i = 1; i < nums.length; i++)
            left[i] = nums[i-1]*left[i-1];

        right[nums.length-1] = 1;
        for(int i = nums.length-2; i >= 0; i--)
            right[i] = nums[i+1]*right[i+1];

        for(int i = 0; i < nums.length; i++)
            result[i] = left[i]*right[i];

        return result;
    }
}
