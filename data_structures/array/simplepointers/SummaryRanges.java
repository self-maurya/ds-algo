package array.simplepointers;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    /*
    LeetCode – Summary Ranges (Java)
    Given a sorted integer array without duplicates, return the summary of its ranges for consecutive numbers.

    For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
     */
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums.length == 1)
            result.add(nums[0] + "");

        int pre = nums[0];
        int first = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == pre+1) {
                if(i == nums.length-1)
                    result.add(first + "->" + nums[i]);
            } else {
                if (first == pre)
                    result.add(first + "");
                else
                    result.add(first + "->" + pre);

                if(i == nums.length-1)
                    result.add(nums[i] + "");

                first = nums[i];
            }
            pre = nums[i];
        }
        return result;
    }
}
