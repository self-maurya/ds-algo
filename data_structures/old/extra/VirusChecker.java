package old.extra;

import java.util.Scanner;

public class VirusChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String virus = sc.nextLine();
        int tests = sc.nextInt();
        String[] subjects = new String[tests];
        int i = 0;
        while (tests > 0) {
            subjects[i++] = sc.next();
            tests--;
        }

        for(String subject: subjects) {
            if (isSubsequence(virus, subject)) {
                System.out.println("POSITIVE");
            } else {
                System.out.println("NEGATIVE");
            }
        }
    }

    public static boolean isSubsequence(String virus, String subject) {
        int j = 0;
        int n = virus.length();
        int m = subject.length();
        for(int i = 0; i < n && j < m; i++) {
            if (virus.charAt(i) == subject.charAt(j)) {
                j++;
            }
        }
        return j == m;
    }
}
