package linkedlist_tail;

public class Solution {

    public static void main(String [] args) {
        Solution sc = new Solution();
        /*Solution.ListNode head = sc.new ListNode(3);
        head.next = sc.new ListNode(2);
        head.next.next = sc.new ListNode(0);
        head.next.next.next = sc.new ListNode(-4);
        head.next.next.next.next = head.next;*/
        Solution.ListNode head = sc.new ListNode(1);

        Solution.ListNode  cycle = detectCycle(head);
        System.out.println(cycle.val);
    }

    public static ListNode detectCycle(ListNode head) {
        ListNode pointer1 = head;
        ListNode pointer2 = head;
        do {
            if(pointer1 == null || pointer2 == null) {return null;}
            pointer1 = pointer1.next;
            pointer2 = pointer2.next!=null ? pointer2.next.next : null;

        }while(pointer1 != pointer2);

        if(pointer1 == null || pointer2 == null) {return null;}
        if(pointer1 == pointer2) {
            pointer1 = head;
            while(pointer1 != pointer2) {
                pointer1 = pointer1.next;
                pointer2 = pointer2.next;
            }
        }
        return pointer1;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode (int val){
            this.val = val;
        }
    }
}
