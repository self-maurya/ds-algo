package array.simplepointers;

public class RepeatedStringMatch {
    /*
    LeetCode – Repeated String Match (Java)

    Given two strings A and B, find the minimum number of times A has to be repeated such that B is a substring of it. If no such solution, return -1.

    For example, with A = "abcd" and B = "cdabcdab".
    Return 3, because by repeating A three times (“abcdabcdabcd”), B is a substring of it; and B is not a substring of A repeated two times ("abcdabcd").

    Note:
    The length of A and B will be between 1 and 10000.
     */
    public int repeatedStringMatch(String A, String B) {
        int i = 0;
        int j = 0;
        int result = 0;
        int k = 0;

        while(j < B.length()) {
            if (A.charAt(i) == B.charAt(j)) {
                i++;
                j++;

                if (i == A.length()) {
                    i = 0;
                    result++;
                }
            } else {
                k++;
                if (k == A.length())
                    return -1;
                i = k;
                j = 0;
                result = 0;
            }
        }

        if (i > 0)
            result++;

        return result;
    }
}
