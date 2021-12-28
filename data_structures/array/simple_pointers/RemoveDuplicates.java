package array.simple_pointers;


public class RemoveDuplicates {
    /**
     * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new
     * length. Do not allocate extra space for another array, you must do this in place with constant memory.
     *
     * For example, given input array A = [1,1,2], your function should return length = 2, and A is now [1,2].
     */
    public static int removeDuplicatesI(int[] a) {
        if (a.length < 2) {
            return a.length;
        }

        int s = 0;
        int m = 1;

        while (m < a.length) {
            if (a[s] != a[m]) {
                s++;
                a[s] = a[m];
            }
            m++;
        }

        return s+1;
    }

    /**
     * What if duplicates are allowed at most twice?
     *
     * For example, given sorted array A = [1,1,1,2,2,3], your function should return length = 5, and A is now
     * [1,1,2,2,3].
     */
    public static int removeDuplicatesII(int[] a) {
        if (a.length < 3) {
            return a.length;
        }

        int s = 1;
        int m = 2;

        while (m < a.length) {
            if (a[s] == a[m] && a[s] == a[s-1]) {
                m++;
            } else {
                s++;
                a[s] = a[m];
                m++;
            }
        }

        return s+1;
    }

    /**
     * Given an array and a value, remove all instances of that value in place and return the new length. (Note: The
     * order of elements can be changed. It doesn't matter what you leave beyond the new length.)
     */
    public static int removeElement(int[] a, int elem) {
        int s = -1;
        int m = 0;

        while (m < a.length) {
            if (a[m] != elem) {
                s++;
                a[s] = a[m];
            }
            m++;
        }

        return s+1;
    }

    /**
     * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of
     * the non-zero elements.
     *
     * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
     */
    public static void moveZeroes(int[] a) {
        int s = -1;
        int m = 0;

        while (m < a.length) {
            if (a[m] != 0) {
                s++;
                a[s] = a[m];
            }
            m++;
        }

        while (s < a.length) {
            a[s] = 0;
            s++;
        }
    }
}
