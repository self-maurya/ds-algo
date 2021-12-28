package old.extra;

public class Test {
    public static void main(String[] args) {
        for(int  i = 1; i < 6; i++)
        System.out.println(fun(i));
    }

    public static int fun(int n) {
        if (n == 0 || n == 1 || n == 2)
            return 0;

        if (n == 3)
            return 1;
        else
            return fun(n-1)+fun(n-2)+fun(n-3);
    }
}
