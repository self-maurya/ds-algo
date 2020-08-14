package array.simplepointers;

import java.util.ArrayList;
import java.util.List;

public class ReverseVowelsOfString {
    /*
    LeetCode – Reverse Vowels of a String (Java)

    Write a function that takes a string as input and reverse only the vowels of a string.
     */
    public String reverseVowels(String s) {
        List<Character> vowList = new ArrayList<Character>();
        vowList.add('a');
        vowList.add('e');
        vowList.add('i');
        vowList.add('o');
        vowList.add('u');
        vowList.add('A');
        vowList.add('E');
        vowList.add('I');
        vowList.add('O');
        vowList.add('U');

        char[] arr = s.toCharArray();
        int i = 0;
        int j = arr.length-1;
        while (i < j) {
            if (!vowList.contains(arr[i])) {
                i++;
                continue;
            }
            if (!vowList.contains(arr[j])) {
                j--;
                continue;
            }
            char t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
            i++;
            j--;
        }

        return new String(arr);
    }
}
