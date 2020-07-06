package array;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] a1 = {1, 1, 2};
        int newLen1 = removeDuplicates1(a1);
        System.out.println(newLen1);
        int[] a2 = {1, 1, 1};
        int newLen2 = removeDuplicates2(a2);
        System.out.println(newLen2);
    }

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

    /*
    LeetCode – Remove Element (Java)
    Given an array and a value, remove all instances of that value in place and return the new length.
    (Note: The order of elements can be changed. It doesn't matter what you leave beyond the new length.)
     */
    public int removeElement(int[] a, int e) {
        int i = 0;
        int j = 0;

        while(i < a.length) {
            if(a[i] != e) {
                a[j] = a[i];
                j++;
            }
            i++;
        }
        return j;
    }

    /*
    LeetCode – Move Zeroes (Java)
    Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

    For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
     */
    public void moveZeroes(int[] a) {
        int i = 0;
        int j = 0;

        while(i < a.length) {
            if(a[i] != 0) {
                a[j] = a[i];
                j++;
            }
            i++;
        }

        while(j < a.length)
            a[j++] = 0;
    }
}
