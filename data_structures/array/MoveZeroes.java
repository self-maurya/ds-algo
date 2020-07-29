package array;

public class MoveZeroes {
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
