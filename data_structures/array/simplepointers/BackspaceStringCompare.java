package array.simplepointers;

public class BackspaceStringCompare {
    /*
    LeetCode – Backspace String Compare (Java)

    Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.

    Example 1:
    Input: S = "ab#c", T = "ad#c"
    Output: true
    Explanation: Both S and T become "ac".
    Example 2:

    Input: S = "a##c", T = "#a#c"
    Output: true
    Explanation: Both S and T become "c".
     */
    public boolean backspaceCompare(String S, String T) {
        int i = S.length()-1;
        int j = T.length()-1;

        while (i >= 0 || j >= 0) {
            int c1 = 0;
            while(i >= 0 && (c1 > 0 || S.charAt(i) == '#')) {
                if (S.charAt(i) == '#')
                    c1++;
                else
                    c1--;
                i--;
            }

            int c2 = 0;
            while(j >= 0 && (c2 > 0 || T.charAt(j) == '#')) {
                if (T.charAt(j) == '#')
                    c2++;
                else
                    c2--;
                j--;
            }

            if (i >= 0 && j >= 0) {
                if (S.charAt(i) != S.charAt(j))
                    return false;
                else {
                    i--;
                    j--;
                }
            } else {
                if (i >= 0 || j >= 0)
                    return false;
            }
        }
        return i < 0 && j < 0;
    }
}
