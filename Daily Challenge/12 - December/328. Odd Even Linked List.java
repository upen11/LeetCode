/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        
        if(head == null || head.next == null ) return head;

        ListNode dummyOdd = head;
        ListNode dummyEven = head.next;

        ListNode evenHead = head.next;

        // dummyEven will always points to last node or null after loop
        while(dummyEven != null && dummyEven.next != null) {
            dummyOdd.next = dummyEven.next;
            dummyEven.next = dummyOdd.next.next;

            dummyOdd = dummyOdd.next;
            dummyEven = dummyEven.next;
        }

        dummyOdd.next = evenHead;

        return head;
    }
}
