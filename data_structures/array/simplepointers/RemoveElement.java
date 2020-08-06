package array.simplepointers;

public class RemoveElement {
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
}
