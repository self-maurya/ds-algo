package array.simplepointers;

import java.util.*;

public class PartitionLabels {
    /*
    LeetCode – Partition Labels (Java)
    A string S of lowercase letters is given. We want to partition this string into as many parts as possible so that
    each letter appears in at most one part, and return a list of integers representing the size of these parts.

    For example:
    Input: S = "ababfeefhijkh"
    Output: [4,4,5]

    Explanation:
    The partition is "abab", "feef", "hijkh". This is a partition so that each letter appears in at most one part.
     */
    public List<Integer> partitionLabels(String S) {
        HashMap<Character, int[]> map = new LinkedHashMap<>();
        for(int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            int[] range = map.getOrDefault(c, new int[]{-1, -1});
            if(range[0] == -1) {
                range[0] = i;
                range[1] = i;
            } else {
                range[1] = i;
            }
            map.put(c, range);
        }

        int[] temp = null;
        List<Integer> result = new ArrayList<>();
        for(Map.Entry<Character, int[]> entry : map.entrySet()) {
            int[] curr = entry.getValue();
            if(temp == null)
                temp = curr;
            else {
                if(curr[0] < temp[1])
                    temp = new int[]{temp[0], Math.max(curr[1], temp[1])};
                else {
                    result.add(temp[1] - temp[0] + 1);
                    temp = curr;
                }
            }
        }
        if (temp != null)
            result.add(temp[1] - temp[0] + 1);
        return result;
    }
}
