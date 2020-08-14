package array.simplepointers;

public class ValidPalindrome {
    /*
    LeetCode – Valid Palindrome (Java)

    Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

    For example, "Red rum, sir, is murder" is a palindrome, while "Programcreek is awesome" is not.
    Note:
    Have you consider that the string might be empty? This is a good question to ask during an interview.

    For the purpose of this problem, we define empty string as valid palindrome.
     */
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int i = 0;
        int j = s.length()-1;

        while(i < j) {
            while(i < j && !(Character.isAlphabetic(s.charAt(i)) || Character.isDigit(s.charAt(i))))
                i++;

            while(i < j && !(Character.isAlphabetic(s.charAt(j)) || Character.isDigit(s.charAt(j))))
                j--;

            if (s.charAt(i) != s.charAt(j))
                return false;

            i++;
            j--;
        }
        return true;
    }
}
