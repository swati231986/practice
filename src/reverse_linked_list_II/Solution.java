package reverse_linked_list_II;

public class Solution {
    public static void main(String [] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);
        head.next.next.next.next.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next.next.next.next.next = new ListNode(10);

        ListNode result = reverseBetween(head, 1,10);
        while(result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null) {return null;}
        if(m == n) {return head;}
        ListNode nodeBeforeM = head;
        ListNode nodeN = head;
        ListNode nodeM = head;

        for(int i =1;i<m-1;i++) {
            nodeM = nodeM.next;
        }
        if( m != 1) {
            nodeBeforeM = nodeM;
            nodeM = nodeM.next;
        }

        for(int i =1;i<n;i++) {
            nodeN = nodeN.next;
        }

        ListNode current = nodeM;
        ListNode next = current.next;
        while(current != nodeN) {
            ListNode temp = next.next;
            next.next = current;
            current = next;
            next = temp;

        }
        if(m == 1) {
            head = nodeN;
        } else {
            nodeBeforeM.next = nodeN;
        }

        nodeM.next = next;
        return head;
    }
}
