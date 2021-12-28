package array.binary_search;

public class MedianOfSortedArrays {
    /**
     * There are two sorted arrays A and B of size m and n respectively. Find the median of the two sorted arrays.
     * The overall run time complexity should be O(log (m+n)).
     */
    public static double findMedianOfSortedArrays(int[] a, int[] b) {
        int t = a.length + b.length;
        if (t%2 == 0) {
            return (getKth(a, 0, a.length-1, b, 0, b.length-1, t/2) +
                    getKth(a, 0, a.length-1, b, 0, b.length-1, t/2 - 1))/2.0;
        } else {
            return getKth(a, 0, a.length-1, b, 0, b.length-1, t/2);
        }
    }

    public static int getKth(int[] a, int l1, int r1, int[] b, int l2, int r2, int k) {
        if (r1 < l1) {
            return b[l2+k];
        }

        if (r2 < l2) {
            return a[l1+k];
        }

        if (k == 0) {
            return Math.min(a[l1], b[l2]);
        }

        int len1 = r1 - l1 + 1;
        int len2 = r2 - l2 + 1;

        int m1 = (k*len1)/(len1+len2);
        int m2 = k - m1 - 1;

        m1 += l1;
        m2 += l2;

        if (a[m1] < a[m2]) {
            k = k - (m1-l1+1);
            l1 = m1+1;
            r2 = m2;
        } else {
            k = k - (m2-l2+1);
            r1 = m1;
            l2 = m2+1;
        }

        return getKth(a, l1, r1, b, l2, r2, k);
    }
}
