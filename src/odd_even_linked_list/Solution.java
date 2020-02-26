package odd_even_linked_list;

public class Solution {
    public static void main(String []args) {
        ListNode head = new ListNode(1);
        //head.next = new ListNode(2);
        /*head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);*/
        //head.next.next.next.next.next.next.next = new ListNode(8);

        ListNode result = oddEvenList(head);

        while(result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public static ListNode oddEvenList(ListNode head) {
        if(head == null) {return null;}

        ListNode odd = head;
        ListNode even = head.next;
        ListNode node = even;
        while(node != null && node.next != null && odd != null && odd.next!=null) {
            odd.next = node.next;
            odd = odd.next;
            node.next = odd.next;
            node = node.next;
        }

        odd.next = even;
        return head;
    }
}
