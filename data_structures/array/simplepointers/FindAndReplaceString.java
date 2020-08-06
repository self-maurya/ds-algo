package array.simplepointers;

import java.util.Map;
import java.util.TreeMap;

public class FindAndReplaceString {
    /*
    LeetCode – Find And Replace in String (Java)
    To some string S, we will perform some replacement operations that replace groups of letters with new ones (not necessarily the same size).

    Each replacement operation has 3 parameters: a starting index i, a source word x and a target word y. The rule is that if x s
    tarts at position i in the original string S, then we will replace that occurrence of x with y. If not, we do nothing.
    For example, if we have S = "abcd" and we have some replacement operation i = 2, x = "cd", y = "ffff", then because "cd"
    starts at position 2 in the original string S, we will replace it with "ffff".
     */
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        TreeMap<Integer, String[]> map = new TreeMap<>();
        for(int i = 0; i < indexes.length; i++)
            map.put(indexes[i], new String[]{sources[i], targets[i]});

        int prev = 0;
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<Integer, String[]> entry : map.entrySet()) {
            int startIndex = entry.getKey();
            int endIndex = startIndex + entry.getValue()[0].length();

            if (prev != startIndex)
                sb.append(S.substring(prev, startIndex));

            String org = S.substring(startIndex, endIndex);
            if(org.equals(entry.getValue()[0]))
                sb.append(entry.getValue()[1]);
            else
                sb.append(org);
            prev = endIndex;
        }

        if (prev < S.length())
            sb.append(S.substring(prev));

        return sb.toString();
    }
}
