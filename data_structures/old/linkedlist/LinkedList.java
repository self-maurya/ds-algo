package old.linkedlist;

public class LinkedList {
    public class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    Node head;

    /*
    inserts node at beginning
     */
    public void push(int newData) {
        Node newNode = new Node(newData);
        newNode.next = head;
        head = newNode;
    }

    /*
    inserts after the prev node
     */
    public void insertAfter(Node prevNode, int newData) {
        if (prevNode == null) {
            return;
        }

        Node newNode = new Node(newData);
        newNode.next = prevNode.next;
        prevNode.next= newNode;
        return;
    }

    /*
    inserts node at last
     */
    public void append(int newData) {
        Node newNode = new Node(newData);

        if (head == null) {
            head = new Node(newData);
            return;
        }

        newNode.next = null;
        Node last = head;
        while(last.next != null) {
            last = last.next;
        }
        last.next = newNode;
        return;
    }

    public void printList(Node list) {
        Node temp = list;
        while(temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
        return;
    }

    public void deleteNodeByPosition(int position) {
        if (head == null)
            return;

        if (position == 0) {
            head = head.next;
            return;
        }

        Node temp = head;
        int i = 0;
        while(temp != null && i < position-1) {
            temp = temp.next;
            i++;
        }

        if (temp == null || temp.next == null)
            return;

        temp.next = temp.next.next;
    }

    public int getCount() {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            count++;
        }
        return count;
    }

    public int getCountRec(Node node) {
        if (node == null)
            return 0;

        return 1 + getCountRec(node.next);
        /*
        first call -> node7
        call(node7) -> 1 + call(node8)
        call(node8) -> 1 + call(node6)
        call(node6) -> 1 + call(node4)
        call(node4) -> 1 + call(null)
         */
    }

    public Node mergeTwoLists(Node node1, Node node2) {
        Node output = new Node(0);
        Node l3 = output;
        Node l1 = node1;
        Node l2 = node2;
        while(l1 != null && l2 != null) {
            if(l1.data < l2.data) {
                l3.next = l1;
                l1 = l1.next;
            } else {
                l3.next = l2;
                l2 = l2.next;
            }
            l3 = l3.next;
        }

        if (l1 != null)
            l3.next = l1;

        if (l2 != null)
            l3.next = l2;

        return output.next;
    }

    // 1 3 2 4 5
    public int nthNode(Node node, int k) {
        if (k == 0)
            return node.data;
        return nthNode(node.next, k-1);
    }

    public int lengthOfLL(Node node) {
        Node temp = node;
        int count = 0;
        while(temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public int lengthOfLLRecursion(Node node) {
        // 1 2 3 4 5 null
        if (node == null)
            return 0;

        return 1 + lengthOfLLRecursion(node.next);
    }
    /*
        call flow:
        main -> lengthOfLLRecursion(n1)
        L162: lengthOfLLRecursion(n1) -> 1 + lengthOfLLRecursion(n2) -> 1 + 4 -> 5
        L162: lengthOfLLRecursion(n2) -> 1 + lengthOfLLRecursion(n3) -> 1 + 3 -> 4
        L162: lengthOfLLRecursion(n3) -> 1 + lengthOfLLRecursion(n4) -> 1 + 2 -> 3
        L162: lengthOfLLRecursion(n4) -> 1 + lengthOfLLRecursion(n5) -> 1 + 1 -> 2
        L162: lengthOfLLRecursion(n5) -> 1 + lengthOfLLRecursion(null) -> 1 + 0 -> 1
     */

    // from starting recursive
    public Node nthNodeRecursion(Node node, int n) {
        if (n == 0)
            return node;
        // 1 2 3 4 5
        return nthNodeRecursion(node.next, n-1);
    }
    /*
        call flow:
        main -> nthNodeRecursion(n1, 3) -> n4
        L179: nthNodeRecursion(n1, 3) -> nthNodeRecursion(n2, 2) -> n4
        L179: nthNodeRecursion(n2, 2) -> nthNodeRecursion(n3, 1) -> n4
        L179: nthNodeRecursion(n3, 1) -> nthNodeRecursion(n4, 0) -> n4
        L179: lengthOfLLRecursion(n4, 0) -> n4
     */

    // from last recursive
    Node nth;
    int n = 3;
    public void nthNodeLastRecursion(Node node) {
        // 1 2 3 4 5
        if (node == null)
            return;

        nthNodeLastRecursion(node.next);
        n--;
        if (n == 0) {
            nth = node;
        }
    }
    /*
     call stack/flow:
     initial values: nth -> null, n = 3
     main -> nthNodeLastRecursion(n1) -> will decrease n to -1
     L197: nthNodeLastRecursion(n2) -> will decrease n to -1
     L197: nthNodeLastRecursion(n3) -> will decrease n to 0 and set nth value to current node which is n3(condition is true here on line 200)
     L197: nthNodeLastRecursion(n4) -> will decrease n to 1
     L197: nthNodeLastRecursion(n5) -> will decrease n to 2
     L197: nthNodeLastRecursion(null) -> return from line 195
     */

    // reverse recursive
    public Node reverseRecursive(Node node) {
        if (node == null || node.next == null)
            return node;

        // 1 2 3 4 5
        Node rest = reverseRecursive(node.next); // rest = 5432
        node.next.next = node; // 54321
        node.next = null;
        return rest;
    }
    /*
    call stack/flow:
    main -> reverseRecursive(n1) -> n5
    L221: reverseRecursive(n1) -> reverseRecursive(n2) -> node = n1, rest = n5 // 5->4->3->2->1->null
    L221: reverseRecursive(n2) -> reverseRecursive(n3) -> node = n2, rest = n5 // 5->4->3->2<-1
    L221: reverseRecursive(n3) -> reverseRecursive(n4) -> node = n3, rest = n5 // 5->4->3<-2<-1
    L221: reverseRecursive(n4) -> reverseRecursive(n5) -> node = n4, rest = n5 // 5->4<-3<-2<-1
     */


    Node left;
    // 1 2 3 2 1 null
    // l       r
    public boolean isPalindrome(Node node) {
        left = node;
        return helper(node);
    }

    public boolean helper(Node right) {
        // 1  2  1 null
        // n1 n2 n3
        // l     r
        if (right == null)
            return true;

        boolean x = helper(right.next); // 1 2 3 2 1 null
        if (!x)
            return false;

        boolean y = (left.data == right.data);
        left = left.next;
        return y;
        // code here
    }
    /*
    call flow:
    main -> isPalindrome(n1)
        left = n1, n2, n3
   isPalindrome(n1) -> helper(n1) -> true
   helper(n1) -> helper(n2)   -> x = true, y = (n3 == n1)true
   helper(n2) -> helper(n3)   -> x = true, y = (n2 == n2)true
   helper(n3) -> helper(null) -> x = true, y = (n1 == n3)true
     */










    public static void main(String[] args) {
        LinkedList llist = new LinkedList();

        llist.append(7);
        llist.push(5);
        llist.push(3);
        llist.append(8);
        llist.insertAfter(llist.head.next, 6);
        llist.printList(llist.head);
        llist.nthNodeLastRecursion(llist.head);
        System.out.println("nth node from last");
        System.out.println(llist.nth.data);
        llist.deleteNodeByPosition(0);
        llist.printList(llist.head);
//        System.out.println(llist.getCount());

        Node l1 = llist.head;
        Node l2 = llist.head;
        Node out = llist.mergeTwoLists(l1, l2);
        llist.printList(out);
        Node temp = llist.head;
//        System.out.println(llist.nthNode(temp, 3));
    }
}
