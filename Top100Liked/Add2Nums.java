package Top100Liked;

class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
        this.next = null;
    }
}
public class Add2Nums {

//    A : 2 -> 4 -> 3
//    B : 5 -> 7 -> 4
    public static Node sum(Node A, Node B) {
        if (A == null && B == null) return null;

        if (A == null) return B;

        if (B == null) return A;

        Node dummy = new Node(-1);
        Node currRes = dummy;
        int carry = 0;
        Node currA = A;
        Node currB = B;
        while (currA != null || currB != null) {

            int x = currA != null ? currA.val : 0;

            int y = currB != null ? currB.val : 0;

            int add = x + y + carry;

            if (add > 9) {
                carry = 1;
                add = add % 10;
            }
            else {
                carry = 0;
            }

            Node node = new Node(add);
            currRes.next = node;
            currRes = node;

            currA = currA != null ? currA.next : null;
            currB = currB != null ? currB.next : null;
        }

        if(carry == 1) {
            Node node = new Node(1);
            currRes.next = node;
        }

        return dummy.next;
    }

    private static void printLL(Node head) {
        if(head == null) System.out.println("No list");

        while(head != null) {
            System.out.print(head.val+" -> ");
            head = head.next;
        }

        System.out.print("null");
    }

    public static void main(String[] args) {

        Node a = new Node(0);
        Node b = new Node(0);
        Node c = new Node(5);

        a.next = b;
        b.next = c;

        Node x = new Node(5);
        Node y = new Node(7);
//        Node z = new Node(4);

        x.next = y;
//        y.next= z;

        Node res = Add2Nums.sum(a, x);

        printLL(res);
    }



}
