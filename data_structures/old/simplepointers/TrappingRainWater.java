package old.simplepointers;

public class TrappingRainWater {
    /*
    LeetCode – Trapping Rain Water (Java)
    Given n non-negative integers representing an elevation map where the width of each bar is 1,
    compute how much water it is able to trap after raining.

    For example, given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
     */
    public int trap(int[] height) {
        int[] left = new int[height.length];
        int[] right = new int[height.length];

        int max = height[0];
        left[0] = height[0];
        for(int i = 1; i < height.length; i++) {
            if(max < height[i])
                max = height[i];
            left[i] = max;
        }

        max = height[height.length-1];
        right[height.length-1] = height[height.length-1];
        for(int i = height.length-2; i >= 0; i--) {
            if(max < height[i])
                max = height[i];
            right[i] = max;
        }

        int result = 0;
        for (int i = 0; i < height.length; i++)
            result += Math.min(left[i], right[i]) - height[i];

        return result;
    }
}
