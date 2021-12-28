package old.extra;

import java.util.*;

public class CandidateCode {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int tests = sc.nextInt();
        int[][] inputs = new int[tests][2];
        int i = 0;
        while (i < tests) {
            String in1 = sc.next();
            String in2 = sc.next();
            inputs[i][0] = Integer.parseInt(in1);
            inputs[i][1] = Integer.parseInt(in2);
            i++;
        }

        for(int[] input: inputs) {
            int s = input[0];
            int e = input[1];
            int a = s;
            int b = e;
            boolean start = false;
            boolean end = false;
            while (a <= e) {
                if (isPrime(a)) {
                    start = true;
                    break;
                }
                a++;
            }

            if (!start) {
                System.out.println(-1);
                continue;
            } else if (a == e) {
                System.out.println(0);
                continue;
            }

            while (b >= s) {
                if (isPrime(b)) {
                    end = true;
                    break;
                }
                b--;
            }

            if (!end) {
                System.out.println(-1);
            } else if (s == b) {
                System.out.println(0);
            } else {
                System.out.println(b-a);
            }
        }
    }

    public static boolean isPrime(int n) {
        if (n <= 1)
            return false;
        else if (n == 2)
            return true;
        else if (n % 2 == 0)
            return false;

        for(int i = 3; i <= Math.sqrt(n); i += 2)
            if (n % i == 0)
                return false;

        return true;
    }
}
