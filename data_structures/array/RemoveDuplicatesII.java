package array;

public class RemoveDuplicatesII {
    /*
    LeetCode – Remove Duplicates from Sorted Array II (Java)
    Follow up for "Remove Duplicates": What if duplicates are allowed at most twice?

    For example, given sorted array A = [1,1,1,2,2,3], your function should return length = 5, and A is now [1,1,2,2,3].
     */
    public static int removeDuplicates2(int[] a) {
        if(a.length < 3)
            return a.length;

        int j = 0;
        int i = 1;

        while(i < a.length) {
            if (a[i] == a[j]) {
                if(j == 0) {
                    i++;
                    j++;
                } else if (a[j] == a[j-1]) {
                    i++;
                } else {
                    j++;
                    a[j] = a[i];
                    i++;
                }
            } else {
                j++;
                a[j] = a[i];
                i++;
            }
        }
        return j+1;
    }
}
