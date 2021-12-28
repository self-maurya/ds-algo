package array.binary_search;

public class SearchInsertPosition {
    public int insertPosition(int[] nums, int target) {
        if (target > nums[nums.length - 1]) {
            return nums.length;
        }

        int i = 0;
        int j = nums.length - 1;

        while (i <= j) {
            int m = (i + j) / 2;
            if (target > nums[m]) {
                i = m + 1;
            } else if (target < nums[m]) {
                j = m - 1;
            } else {
                return m;
            }
        }

        return i;
    }
}
