package old.simplepointers;

public class MergeSortedArray {
    /*
    LeetCode – Merge Sorted Array (Java)

    Given two sorted integer arrays A and B, merge B into A as one sorted array.

    Note:
    You may assume that A has enough space to hold additional elements from B. The number of elements initialized in A and B are m and n respectively.
     */
    public void merge(int[] A, int m, int[] B, int n) {
        int i = m-1;
        int j = n-1;
        int k = m+n-1;

        while(k >= 0) {
            if(j < 0 || (i >= 0 && A[i] > B[j]))
                A[k--] = A[i--];
            else
                A[k--] = B[j--];
        }
    }
}
