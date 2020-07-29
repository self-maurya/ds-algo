package array;

public class RemoveDuplicatesI {
    /*
    LeetCode – Remove Duplicates from Sorted Array (Java)
    Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
    Do not allocate extra space for another array, you must do this in place with constant memory.

    For example, given input array A = [1,1,2], your function should return length = 2, and A is now [1,2].
     */
    public static int removeDuplicates1(int[] a) {
        if(a.length < 2)
            return a.length;

        int j = 0;
        int i = 1;
        while(i < a.length) {
            if(a[i] != a[j]) {
                j++;
                a[j] = a[i];
            }
            i++;
        }
        return j+1;
    }
}
