package old.linkedlist;

public class StackUsingArray {
    int MAX = 1000;
    int top; // index of last element inserted
    int[] a = new int[MAX];

    StackUsingArray() {
        top = -1; // for empty reference
    }

    public boolean isEmpty() {
        return top < 0;
    }

    public boolean push(int x) {
        if (top >= MAX - 1) {
            return false;
        } else {
            top++;
            a[top] = x;
            return true;
        }
    }

    public int pop() {
        if (isEmpty()) {
            return -1;
        } else {
            int x = a[top];
            top--;
            return x;
        }
    }

    public int peek() {
        if (isEmpty()) {
            return -1;
        } else {
            return a[top];
        }
    }

    public void display() {
        if (isEmpty())
            return;
        for(int i = top; i >= 0; i--) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        StackUsingArray s = new StackUsingArray();
        s.push(5);
        s.push(4);
        s.push(3);
        s.push(2);
        s.push(1);
        s.display();
        System.out.println(s.peek());
        s.pop();
        s.pop();
        s.push(6);
        s.display();
        System.out.println(s.peek());
    }
}
