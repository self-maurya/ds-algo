package old.other;

/**
 * Given a sorted positive integer array nums and an integer n, add/patch elements to the array such that any number in range [1, n] inclusive can be formed by the sum of some elements in the array. Return the minimum number of patches required.
 *
 * Example 1:
 * nums = [1, 3], n = 6
 * Return 1.
 */
public class PatchingArray {
    public int minPatches(int[] nums, int n) {
        int count = 0;
        int miss = 1;
        int i = 0;

        while(miss <= n) {
            if (i < nums.length && nums[i] <= miss) {
                miss += nums[i];
                i++;
            } else {
                miss += miss;
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        PatchingArray pa = new PatchingArray();
        System.out.println(pa.minPatches(new int[]{1, 5, 10}, 20));
    }
}
